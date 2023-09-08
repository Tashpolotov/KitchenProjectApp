package com.example.kitchenprojectapp.fragment.categoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.CategoryModel
import com.example.kitchenprojectapp.R
import com.example.kitchenprojectapp.databinding.FragmentCategoryBinding
import com.example.kitchenprojectapp.fragment.foodfragment.FoodFragment
import com.example.kitchenprojectapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private lateinit var binding:FragmentCategoryBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter = CategoryAdapter(this::onCLick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        binding.tvCategoryName.text = "${name} cuisine"
        initAdapter()
        initBtn()
    }

    private fun initBtn() {
        binding.imgBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun initAdapter() {
        binding.rv3.adapter = adapter
        val name = arguments?.getString("name")
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.home.collect { homeData ->
                // Фильтруем список блюд по выбранной категории
                val categoryFoodList = homeData.categoryFood.filter { it.name == name }
                adapter.submitList(categoryFoodList)
            }
        }
        viewModel.loadCategoryFood()
    }

    private fun onCLick(model:CategoryModel) {
        val fragment = FoodFragment()
        val bundle = Bundle()
        bundle.putString("calories", model.calories)
        bundle.putString("protein", model.protein)
        bundle.putString("fat", model.fat)
        bundle.putString("carbs", model.carbs)
        bundle.putInt("img", model.img)
        bundle.putString("ingredient", model.foodIngredient)
        bundle.putString("info", model.foodInfo)
        bundle.putString("name", model.foodName)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}