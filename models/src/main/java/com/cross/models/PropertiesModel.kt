package com.cross.models

data class PropertiesModel(
    val place: String,
    val time: Long,
    val updated: Long,
    val tz: Any? = null,
    val url: String,
    val detail: String,
    val felt: Any? = null,
    val cdi: Any? = null,
    val mmi: Any? = null,
    val alert: Any? = null,
    val status: String? = null,
    val tsunami: Int,
    val sig: Int,
    val net: String,
    val code: String,
    val ids: String,
    val sources: String,
    val types: String,
    val nst: Int,
    val dnim: Float,
    val rms: Float,
    val gap: Int,
    val magType: String,
    val title: String
)