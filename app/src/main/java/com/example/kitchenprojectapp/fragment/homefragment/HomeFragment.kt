package com.example.kitchenprojectapp.fragment.homefragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.domain.model.HomeButtonModel
import com.example.domain.model.HomePopularModel
import com.example.kitchenprojectapp.R
import com.example.kitchenprojectapp.databinding.FragmentHomeBinding
import com.example.kitchenprojectapp.fragment.categoryfragment.CategoryFragment
import com.example.kitchenprojectapp.fragment.homefragment.adapter.HomeAdapter
import com.example.kitchenprojectapp.fragment.homefragment.adapter.HomeCategoryAdapter
import com.example.kitchenprojectapp.fragment.homefragment.adapter.HomeFoodAdapter
import com.example.kitchenprojectapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter = HomeAdapter(this::onClickPopular)

    private val adapterFood = HomeFoodAdapter()

    private val adapterCategory = HomeCategoryAdapter(this::onClick)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter(id = String())
    }


    private fun initAdapter(id:String) {
        binding.rv1.adapter = adapter
        binding.rv3.adapter = adapterFood
        binding.rv2.adapter = adapterCategory

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.home.collect{
                adapterFood.submitList(it.homeFood)
                adapter.submitList(it.home)
                adapterCategory.submitList(it.homeButton)
            }
        }
        viewModel.loadHome(id)
        viewModel.loadHomeFood(id)
        viewModel.loadHomeCategory()
    }

    private fun onClickPopular(model:HomePopularModel) {
        val fragment = PopularFragment()
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

    private fun onClick(model:HomeButtonModel) {
        Log.e("ololo", "Button clicked: ${model.name}")
        val fragment = CategoryFragment()
        val bundle = Bundle()
        bundle.putString("name", model.name)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}