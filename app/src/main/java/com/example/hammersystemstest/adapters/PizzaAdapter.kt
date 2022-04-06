package com.example.hammersystemstest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammersystemstest.databinding.PizzaItemBinding
import com.example.hammersystemstest.data.model.PizzaItem

class PizzaAdapter : ListAdapter<PizzaItem, PizzaAdapter.PizzaViewHolder>(PizzaComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val binding =
            PizzaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PizzaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class PizzaViewHolder(private val binding: PizzaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pizza: PizzaItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(pizza.avatar)
                    .into(pizzaImageView)

                nameTextView.text = pizza.first_name
                descriptionTextView.text = pizza.email
                priceTextView.text = "от ${pizza.id*125}₽"
            }
        }
    }

    class PizzaComparator : DiffUtil.ItemCallback<PizzaItem>() {
        override fun areItemsTheSame(oldItem: PizzaItem, newItem: PizzaItem) =
            oldItem.email == newItem.email

        override fun areContentsTheSame(oldItem: PizzaItem, newItem: PizzaItem) =
            oldItem == newItem
    }
}