package com.shanks.wikinews.FeaturedImages.viewModels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shanks.wikinews.FeaturedImages.models.FeaturedImagesList
import com.shanks.wikinews.FeaturedImages.repo.FeaturedImagesRepo


class MainViewModel(private val repo: FeaturedImagesRepo): ViewModel() {

    suspend fun getFeaturedImage(){
    Log.d("REQUEST", "FIRST")
    repo.getFeaturedImages("query","imageinfo","timestamp%7Cuser%7Curl"
        ,"categorymembers", "file", "Category:Featured_pictures_on_Wikimedia_Commons","json")
    }

    suspend fun continueLoadingImages( continuee : String){
        Log.d("REQUEST", "Continuee")
        repo.continueLoadingImages(continuee)
    }

     val featuredImages : LiveData<FeaturedImagesList>
     get() = repo.featuredImages
    var imageListSize: Int = 0
    var isimageListchanged : LiveData<Boolean> = repo.isimageListchanged
}
