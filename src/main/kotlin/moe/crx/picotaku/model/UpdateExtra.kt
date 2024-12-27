package moe.crx.picotaku.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateExtra(
    @SerialName("download_time")
    val downloadTime: Long?, //probably timestamp
    @SerialName("install_time")
    val installTime: Long?, //probably timestamp
    @SerialName("model")
    val model: String
)
