package com.shanks.wikinews.FeaturedImages.api

import retrofit2.http.GET
import retrofit2.http.Query

interface FeaturedImagesServices {

    @GET("api.php?action=query&prop=imageinfo&iiprop=timestamp%7Cuser%7Curl&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&utf8")
    suspend fun getFeaturedImages(
    ) : String

    @GET("api.php?action=query&prop=imageinfo&iiprop=timestamp|user|url&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&utf8")
    suspend fun getFeatureContinueImages(@Query("gcmcontinue") continueStr: String): String


}