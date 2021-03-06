package com.example.churchapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.churchapp.databinding.FellowshipItemBinding
import com.example.churchapp.models.Fellowship

class FellowshipAdapter(val clickListener:OnClickListener) : ListAdapter<Fellowship,FellowshipAdapter.FellowshipViewHolder>(FellowshipDiffUtill) {

    inner class FellowshipViewHolder(val binding:FellowshipItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Fellowship) {
            binding.description.text = item.description
            binding.fellowshipDate.text = item.created_at
            binding.scripture.text = item.title?.toUpperCase()
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FellowshipViewHolder {
        return FellowshipViewHolder(FellowshipItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FellowshipViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(item)
        }
        holder.bind(item)
    }

    companion object FellowshipDiffUtill:DiffUtil.ItemCallback<Fellowship>() {
        override fun areItemsTheSame(oldItem: Fellowship, newItem: Fellowship): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fellowship, newItem: Fellowship): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener:(fellowship:Fellowship)->Unit) {
        fun onClick(fellowship: Fellowship) = clickListener(fellowship)
    }

}