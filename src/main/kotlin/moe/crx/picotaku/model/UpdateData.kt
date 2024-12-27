package moe.crx.picotaku.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateData(
    @SerialName("trace")
    val trace: String,
    @SerialName("extra")
    val extra: UpdateExtra,
    @SerialName("meta")
    val meta: UpdateMeta,
    @SerialName("package")
    val packages: List<UpdatePackage>
)
