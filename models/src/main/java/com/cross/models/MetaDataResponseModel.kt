package com.cross.models

data class MetaDataResponseModel(
    val generated: Long,
    val url: String,
    val title: String,
    val status: Int,
    val api: String,
    val count: Int
)