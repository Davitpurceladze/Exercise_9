package com.example.exercise_9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_9.databinding.ShopItemBinding

class RecyclerAdapter():
    ListAdapter<Data.Item,RecyclerAdapter.RecyclerViewHolder>(object :DiffUtil.ItemCallback<Data.Item>(){

        override fun areItemsTheSame(oldItem: Data.Item, newItem: Data.Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data.Item, newItem: Data.Item): Boolean {
            return oldItem == newItem
        }
    }) {

    fun setData(item: MutableList<Data.Item>){

        submitList(item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShopItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind()
    }

    inner class RecyclerViewHolder(private val binding: ShopItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = currentList[adapterPosition]
            with(binding) {
                imgItemPhoto.setImageResource(item.image)
                tvItemTitle.text = item.title
                tvItemPrice.text = item.price
                tvItemCategory.text = item.categoryType
            }
        }
    }
}