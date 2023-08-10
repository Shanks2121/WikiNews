package com.shanks.wikinews.FeaturedImages.models

data class FeaturedImagesList(
    var batchcomplete: String? = null,
    var continuee: Continue? = Continue(),
    var query: Query? = Query())