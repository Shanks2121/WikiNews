@file:Suppress("DEPRECATION")

package com.shanks.wikinews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shanks.wikinews.FeaturedImages.ui.FeaturedImageFragment

class   PagerAdapter(fragManager: FragmentManager) : FragmentPagerAdapter(fragManager) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return FeaturedImageFragment()
//            2 -> return CategoryFragment()
//            1 -> return RandomArticleFragment()
            else -> return FeaturedImageFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Featured Images"
            1 -> "Random Article"
            2 -> "Categories"
            else -> "Feature images"
        }
    }
}