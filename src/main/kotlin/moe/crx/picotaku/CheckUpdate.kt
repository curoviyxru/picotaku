package moe.crx.picotaku

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import moe.crx.picotaku.model.UpdateRequest
import moe.crx.picotaku.model.UpdateResult
import moe.crx.picotaku.ota.OemState
import moe.crx.picotaku.ota.PicoProduct
import java.net.URI
import java.security.MessageDigest
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.net.ssl.HttpsURLConnection

object CheckUpdate {
    fun calculateMD5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray(Charsets.UTF_8))
        return digest.joinToString("") { "%02x".format(it) }
    }

    fun calculateHMACSHA256(data: String, secret: String): String {
        val algorithm = "HmacSHA256"
        val secretKeySpec = SecretKeySpec(secret.toByteArray(Charsets.UTF_8), algorithm)
        val mac = Mac.getInstance(algorithm).apply {
            init(secretKeySpec)
        }
        val hmacBytes = mac.doFinal(data.toByteArray(Charsets.UTF_8))
        return Base64.getEncoder().encodeToString(hmacBytes)
    }

    fun makeRequest(product: PicoProduct, serial: String, oemState: OemState): UpdateResult {
        val request = UpdateRequest(
            buildType = oemState.oemState,
            product = product.productName,
            udid = serial,
            model = product.model
        )

        val json = Json {
            encodeDefaults = true
        }

        val body = json.encodeToString(request)
        val hashedBody = calculateMD5(body)
        val signature = calculateHMACSHA256("POST\n\n$hashedBody\n", product.secretKey)

        val url =
            URI("https://${product.endpoint.url}/open/v3/ota/check").toURL().openConnection() as HttpsURLConnection

        url.requestMethod = "POST"
        url.doOutput = true
        url.setRequestProperty("Content-Type", "application/json")
        url.setRequestProperty("Cache-Control", "no-cache")
        url.setRequestProperty("X-Signature", "${product.accessKey}:$signature")

        url.outputStream.bufferedWriter().apply {
            write(body)
            flush()
        }
        val response = url.inputStream.bufferedReader().readText()
        url.disconnect()

        return json.decodeFromString<UpdateResult>(response)
    }
}