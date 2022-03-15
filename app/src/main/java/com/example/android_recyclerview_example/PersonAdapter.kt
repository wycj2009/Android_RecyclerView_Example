package com.example.android_recyclerview_example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_recyclerview_example.databinding.ItemCardBinding

class PersonAdapter(private val items: List<Person>, private val clickCallback: (name: String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PersonViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                clickCallback.invoke(items[adapterPosition].name)
            }
        }

        fun bind(item: Person) {
            binding.profile.setImageResource(item.profileResId)
            binding.name.text = item.name
        }

    }

}