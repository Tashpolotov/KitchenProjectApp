package com.example.kitchenprojectapp.fragment.categoryfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CategoryModel
import com.example.kitchenprojectapp.databinding.ItemCategoryFoodBinding

class CategoryAdapter(val onClick:(CategoryModel)->Unit):ListAdapter<CategoryModel, CategoryAdapter.CategoryViewHolder>(CaetgoryDiff()) {


    inner class CategoryViewHolder(val binding:ItemCategoryFoodBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CategoryModel) {
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgHome)

            binding.tvFoodName.text = model.foodName
            binding.tvGram.text = "${model.gram} g"
            binding.tvKcal.text = "${model.kcal} kcal"

            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CaetgoryDiff:DiffUtil.ItemCallback<CategoryModel>() {
    override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem == newItem
    }

}
