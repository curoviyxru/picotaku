package moe.crx.picotaku.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateMeta(
    @SerialName("deadline")
    val deadline: Long,
    @SerialName("desc_url")
    val descriptionUrl: String,
    @SerialName("desc_text")
    val descriptionText: String,
    @SerialName("desc_detail")
    val descriptionDetail: String,
    @SerialName("desc_type")
    val descriptionType: Int,
    @SerialName("install_type")
    val installType: Int,
    @SerialName("retry_count")
    val retryCount: Int,
    @SerialName("retry_interval")
    val retryInterval: Int,
    @SerialName("version")
    val version: String,
    @SerialName("version_type")
    val versionType: String, //RELEASE
    @SerialName("buildtime")
    val buildTime: Long,
    @SerialName("publish_type")
    val publishType: String //gray_released, full_released
)