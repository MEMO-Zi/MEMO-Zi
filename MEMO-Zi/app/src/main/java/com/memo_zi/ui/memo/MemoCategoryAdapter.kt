package com.memo_zi.ui.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.R
import com.memo_zi.data.model.MemoCategory

class MemoCategoryAdapter(
    private val context: Context,
    private val categories: List<MemoCategory>
) : RecyclerView.Adapter<MemoCategoryAdapter.ModelViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_memo_category, parent, false)
        return ModelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int = categories.size
    inner class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: MemoCategory) {
            itemView.findViewById<ImageView>(R.id.category_img).setImageResource(category.imageRes)
            itemView.findViewById<TextView>(R.id.category_title).text = category.title
        }
    }

}
