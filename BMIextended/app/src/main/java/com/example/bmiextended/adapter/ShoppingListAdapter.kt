package com.example.bmiextended.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.bmiextended.R
import com.example.bmiextended.model.ShoppingItem

class ShoppingListAdapter(
    private var items: List<ShoppingItem>,
    private val onCheckedChange: (Int) -> Unit
) : RecyclerView.Adapter<ShoppingListAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val cb: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.cb.text = item.name
        holder.cb.isChecked = item.isChecked
        holder.cb.setOnClickListener { onCheckedChange(position) }
    }

    override fun getItemCount(): Int = items.size

    fun updateList(newItems: List<ShoppingItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
