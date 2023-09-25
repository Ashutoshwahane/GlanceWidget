package dev.ashutoshwahane.glancewidgets

import dev.ashutoshwahane.glancewidgets.entity.ImageEntity
import entity.MarsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

    @GET("planetary/apod")
    suspend fun getApodImage(
        @Query("api_key") key: String
    ): ImageEntity


    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=100")
    suspend fun getMarsImage(@Query("api_key") key: String): MarsEntity

}
