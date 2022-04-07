package com.crossapp.catalogs.api

import com.cross.models.EarthquakeResponseModel
import retrofit2.http.GET

interface CrossCatalogsServiceApi {
    @GET
    fun getCatalogs(): Result<EarthquakeResponseModel>
}