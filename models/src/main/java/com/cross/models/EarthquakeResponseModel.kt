package com.cross.models

data class EarthquakeResponseModel(
    val type: String,
    val metadata: MetaDataResponseModel,
    val features: List<FeatureModel>,
    val bbox: List<Int>
)