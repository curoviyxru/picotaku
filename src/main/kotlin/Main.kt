package moe.crx

import moe.crx.picotaku.CheckUpdate
import moe.crx.picotaku.ota.OemState
import moe.crx.picotaku.ota.PicoProduct
import java.time.Instant

fun main(args: Array<String>) {
    var deviceArg = if (args.isNotEmpty()) args[0] else null
    var serialArg = if (args.size >= 2) args[1] else null

    if (deviceArg == null) {
        println("Available devices:")
        PicoProduct.entries.forEach { println("- ${it.name}") }
        print("Specify device: ")
        deviceArg = readln().uppercase()
    }

    val device: PicoProduct? = PicoProduct.entries.find {
        it.name == deviceArg
    }

    if (device == null) {
        return
    }

    if (serialArg == null) {
        print("Enter serial: ")
        serialArg = readln()
    }

    OemState.entries.forEach {
        val result = CheckUpdate.makeRequest(device, serialArg, it)
        println("Available ${it.name}:")

        if (result.data == null) {
            println("- Error: ${result.code}, ${result.errorMessage}")
            return@forEach
        }

        result.data.meta.apply {
            println("- Version: $version $versionType $publishType")
            println("- Build time: ${Instant.ofEpochSecond(buildTime)}")
            println(descriptionText)
            println("- Packages:")
        }
        result.data.packages.forEach { p ->
            println(p.name)
            println("- ID: ${p.id}")
            println("- MD5: ${p.md5}")
            println("- Size: ${p.size} bytes")
            println("- Build time: ${Instant.ofEpochSecond(p.buildTime)}")
            println("- URLs:")
            println(p.url)
            p.backupUrls.forEach { url -> println(url) }
        }
        println()
    }
}