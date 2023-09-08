package com.example.kitchenprojectapp.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeButtonModel
import com.example.domain.model.HomeModel
import com.example.kitchenprojectapp.R
import com.example.kitchenprojectapp.databinding.ItemCategoryKitchenBinding
import com.example.kitchenprojectapp.databinding.ItemFoodBinding

class HomeCategoryAdapter(val onCLick:(HomeButtonModel)-> Unit): ListAdapter<HomeButtonModel, HomeCategoryAdapter.HomeCategoryViewHolder>(HomeCategoryDiff()) {

    inner class HomeCategoryViewHolder(val binding: ItemCategoryKitchenBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeButtonModel) {

            binding.btnCategort.text = model.name

            binding.btnCategort.setOnClickListener {
                onCLick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        return HomeCategoryViewHolder(ItemCategoryKitchenBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeCategoryDiff: DiffUtil.ItemCallback<HomeButtonModel>() {
    override fun areItemsTheSame(oldItem: HomeButtonModel, newItem: HomeButtonModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeButtonModel, newItem: HomeButtonModel): Boolean {
        return oldItem == newItem
    }

}
