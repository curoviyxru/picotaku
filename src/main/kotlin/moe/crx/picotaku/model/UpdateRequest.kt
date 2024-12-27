package moe.crx.picotaku.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateRequest(
    @SerialName("apps")
    val appBaseline: Map<String, Int> = mapOf(),
    @SerialName("bc_flag")
    val bcFlag: Int = 2, //1 is TOB, 2 is not
    @SerialName("buildtime")
    val buildTime: String = "0",
    @SerialName("buildtype")
    val buildType: String,
    @SerialName("channel")
    val channel: String = "",
    @SerialName("country_code")
    val countryCode: String = "",
    @SerialName("devsec")
    val deviceSecret: String = "",
    @SerialName("did")
    val did: String = "",
    @SerialName("flag")
    val flag: String = "1", //1/0 - need full ota package
    @SerialName("language")
    val language: String = "en",
    @SerialName("model")
    val model: String = "",
    @SerialName("network")
    val network: String = "",
    @SerialName("os_version")
    val osVersion: String = "5.8.2",
    @SerialName("power")
    val power: String = "",
    @SerialName("product")
    val product: String,
    @SerialName("product_name")
    val productName: String = "",
    @SerialName("rom_version")
    val romVersion: String = "",
    @SerialName("udid")
    val udid: String,
)