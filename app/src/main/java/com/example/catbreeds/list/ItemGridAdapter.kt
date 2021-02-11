package com.example.catbreeds.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.databinding.ListViewItemBinding
import com.example.catbreeds.network.BreedProperty

class ItemGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<BreedProperty, ItemGridAdapter.BreedPropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGridAdapter.BreedPropertyViewHolder {
        return BreedPropertyViewHolder(ListViewItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: ItemGridAdapter.BreedPropertyViewHolder, position: Int) {
        val breedProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(breedProperty)
        }
        holder.bind(breedProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<BreedProperty>() {
        override fun areItemsTheSame(oldItem: BreedProperty, newItem: BreedProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: BreedProperty, newItem: BreedProperty): Boolean {
            return oldItem.id == oldItem.id
        }
    }

    class BreedPropertyViewHolder(private var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(breedProperty: BreedProperty){
            binding.property = breedProperty
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (breedProperty:BreedProperty) -> Unit) {
        fun onClick(breedProperty:BreedProperty) = clickListener(breedProperty)
    }

}