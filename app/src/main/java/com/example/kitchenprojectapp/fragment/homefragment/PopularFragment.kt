package com.example.kitchenprojectapp.fragment.homefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kitchenprojectapp.R
import com.example.kitchenprojectapp.databinding.FragmentPopularBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment() {

    private lateinit var binding:FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBundle()
    }

    private fun initBundle() {
        val calories = arguments?.getString("calories")
        val protein = arguments?.getString("protein")
        val fat = arguments?.getString("fat")
        val carbs = arguments?.getString("carbs")
        val img = arguments?.getInt("img")
        val ingredient = arguments?.getString("ingredient")
        val info = arguments?.getString("info")
        val name = arguments?.getString("name")

        binding.tvNameFood.text = name
        binding.tvFoodIngredient.text = ingredient
        binding.tvFoodInfo.text = info
        binding.tvCaloriesGram.text = calories
        binding.tvGramProtein.text = protein
        binding.tvGramFat.text = fat
        binding.tvGramCarbs.text = carbs
        if (img != null) {
            binding.imgFood.setImageResource(img)
        }
        binding.imgBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}