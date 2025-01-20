package com.jkweyu.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jkweyu.viewbinding.databinding.ItemRvBinding



class RVAdapter : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    private var items: List<RVItem> = listOf()

    // 데이터 설정
    fun setItems(newItems: List<RVItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    // 뷰홀더 클래스
    class ItemViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RVItem) {
            binding.itemText.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

