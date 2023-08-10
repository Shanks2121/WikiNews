package com.shanks.wikinews

import android.app.Application


import com.shanks.wikinews.FeaturedImages.api.FeaturedImagesServices
import com.shanks.wikinews.FeaturedImages.api.RetrofitHelper
import com.shanks.wikinews.FeaturedImages.repo.FeaturedImagesRepo

class WikiAppilcation: Application() {
    lateinit var featuredImagesRepo: FeaturedImagesRepo
//    lateinit var randomArticleRepo: RandomArticleRepo
    override fun onCreate() {
        super.onCreate()
        initilizer()
    }

    private fun initilizer() {
        val featuredImagesServices = RetrofitHelper.getRetrofitBuilder().create(
            FeaturedImagesServices::class.java)
        featuredImagesRepo = FeaturedImagesRepo(featuredImagesServices,
            //ImagesDatabase.getDatabase(applicationContext),
      applicationContext)

//        val randomArticleServices = RetrofitHelper.getRetrofitBuilder().create(RandomArticleServices::class.java)
//        randomArticleRepo = RandomArticleRepo(randomArticleServices,
//            //ImagesDatabase.getDatabase(applicationContext),
//            applicationContext)
    }
}