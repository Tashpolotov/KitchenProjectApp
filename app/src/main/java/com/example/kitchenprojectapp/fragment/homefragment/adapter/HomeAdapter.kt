package com.example.kitchenprojectapp.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeModel
import com.example.domain.model.HomePopularModel
import com.example.kitchenprojectapp.databinding.ItemHomeBinding

class HomeAdapter(val onClick:(HomePopularModel)->Unit):ListAdapter<HomePopularModel, HomeAdapter.HomeViewHolder>(HomeDiff()) {


    inner class HomeViewHolder(val binding:ItemHomeBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomePopularModel) {
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgHome)

            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeDiff:DiffUtil.ItemCallback<HomePopularModel>() {
    override fun areItemsTheSame(oldItem: HomePopularModel, newItem: HomePopularModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomePopularModel, newItem: HomePopularModel): Boolean {
        return oldItem == newItem
    }

}
