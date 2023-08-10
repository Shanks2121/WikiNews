package com.shanks.wikinews.FeaturedImages.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.shanks.wikinews.FeaturedImages.models.FeaturedImagesList
import com.shanks.wikinews.FeaturedImages.models.Page
import com.shanks.wikinews.FeaturedImages.viewModels.MainViewModel
import com.shanks.wikinews.FeaturedImages.viewModels.ViewModelFactory
import com.shanks.wikinews.R
import com.shanks.wikinews.WikiAppilcation
import com.shanks.wikinews.databinding.FragmentFeaturedImageBinding
import kotlinx.coroutines.launch


class FeaturedImageFragment : Fragment() {

    lateinit var binding: FragmentFeaturedImageBinding
    lateinit var viewmodel: MainViewModel
    var imageList: FeaturedImagesList? = FeaturedImagesList()
    private var list : ArrayList<Page?> = ArrayList()
    private var temp : String = ""
    lateinit var adapter: FeaturedImagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeaturedImageBinding.inflate(layoutInflater,container,false)


        val repo= (activity?.application as WikiAppilcation).featuredImagesRepo
        viewmodel = ViewModelProvider(this, ViewModelFactory(repo))[MainViewModel::class.java]

        viewmodel.viewModelScope.launch { viewmodel.getFeaturedImage() }
        fetchData();
        //setup RecyclerView
        binding.imageRecycleView.layoutManager = GridLayoutManager(this.requireContext(),2)
        adapter = FeaturedImagesAdapter(list, viewLifecycleOwner, viewmodel,requireActivity())

        binding.imageRecycleView.adapter = adapter

        return binding.root
    }

    private fun fetchData() {
        viewmodel.featuredImages.observe(viewLifecycleOwner){
            val result = it.query?.pages?.pageList
            if (result != null) {
                for (items in result)
                {
                    list.add(items)
                }

            }
            Log.d("items", list.toString())
            adapter.notifyItemInserted(viewmodel.imageListSize)
            viewmodel.imageListSize = list.size

        }
    }
}