package com.cross.models

data class FeatureModel(
    val type: String,
    val properties: PropertiesModel,
    val geometry: GeometryModel,
    val id: String
)