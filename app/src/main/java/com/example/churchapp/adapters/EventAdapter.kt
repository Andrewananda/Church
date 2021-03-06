package com.example.churchapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.churchapp.databinding.EventItemBinding
import com.example.churchapp.models.Event

class EventAdapter(val clickListener:OnClickListener) : ListAdapter<Event,EventAdapter.EventViewHolder>(EventDiffUtil) {
    inner class EventViewHolder(val binding:EventItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Event) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.eventDate.text = item.date
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(EventItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(item)
        }
        holder.bind(item)
    }

    companion object EventDiffUtil:DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }

    }
    class OnClickListener(val clickListener : (event:Event)->Unit ) {
        fun onClick(event:Event) = clickListener(event)
    }
}