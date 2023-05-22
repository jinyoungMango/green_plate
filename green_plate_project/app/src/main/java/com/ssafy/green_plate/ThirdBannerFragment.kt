package com.ssafy.green_plate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.ssafy.green_plate.config.ApplicationClass
import com.ssafy.green_plate.databinding.FragmentThirdBannerBinding
import com.ssafy.green_plate.dto.Product

class ThirdBannerFragment : Fragment() {
    private var _binding : FragmentThirdBannerBinding? = null
    private val binding
        get() = _binding!!
    private val activityViewModel: MainActivityViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topThreeMenuObserver()
    }

    private fun topThreeMenuObserver() {
        activityViewModel.topThreeMenuInfo.observe(viewLifecycleOwner) {
            var recommendList = it as MutableList<Product>
            binding.thirdRecommandMenuTv.text = recommendList.get(2).name
            binding.thirdRecommandDiscripTv.text = recommendList.get(2).discription.split("(").get(0)
            view?.let { it1 ->
                Glide.with(it1)
                    .load("${ApplicationClass.MENU_IMGS_URL}${recommendList.get(2).img}")
                    .into(binding.thirdRecommandImg)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}