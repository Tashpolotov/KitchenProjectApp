package com.example.kitchenprojectapp.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeModel
import com.example.kitchenprojectapp.databinding.ItemFoodBinding



class HomeFoodAdapter: ListAdapter<HomeModel, HomeFoodAdapter.HomeFoodViewHolder>(HomeFoodDiff()) {


    inner class HomeFoodViewHolder(val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel) {
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgHome)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFoodViewHolder {
        return HomeFoodViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeFoodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeFoodDiff: DiffUtil.ItemCallback<HomeModel>() {
    override fun areItemsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
        return oldItem == newItem
    }

}
