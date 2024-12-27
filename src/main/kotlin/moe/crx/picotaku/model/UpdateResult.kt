package moe.crx.picotaku.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateResult(
    @SerialName("code")
    val code: Int,
    @SerialName("errmsg")
    val errorMessage: String,
    @SerialName("data")
    val data: UpdateData? = null
)