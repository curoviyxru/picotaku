package moe.crx.picotaku.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdatePackage(
    @SerialName("id")
    val id: Long,
    @SerialName("md5")
    val md5: String,
    @SerialName("name")
    val name: String,
    @SerialName("size")
    val size: Long,
    @SerialName("type")
    val type: Int,
    @SerialName("url")
    val url: String,
    @SerialName("bak_urls")
    val backupUrls: List<String>,
    @SerialName("version")
    val version: String,
    @SerialName("buildtime")
    val buildTime: Long,
    @SerialName("enableIdleUpgrade")
    val enableIdleUpgrade: Boolean
)