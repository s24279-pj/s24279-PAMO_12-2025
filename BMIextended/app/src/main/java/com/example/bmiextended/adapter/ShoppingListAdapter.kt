package com.example.bmiextended.adapter

import android.view.*
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.bmiextended.R
import com.example.bmiextended.model.ShoppingItem

class ShoppingListAdapter(
    private var items: List<ShoppingItem>,
    private val onCheckedChange: (Int) -> Unit
) : RecyclerView.Adapter<ShoppingListAdapter.VH>() {

    inner class VH(view: View): RecyclerView.ViewHolder(view) {
        val cb: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int) =
        LayoutInflater.from(p.context)
            .inflate(R.layout.item_shopping, p, false)
            .let { VH(it) }

    override fun onBindViewHolder(h: VH, i: Int) {
        val it = items[i]
        h.cb.text = it.name
        h.cb.isChecked = it.isChecked
        h.cb.setOnClickListener { onCheckedChange(i) }
    }

    override fun getItemCount() = items.size

    fun updateList(newItems: List<ShoppingItem>) {
        items = newItems; notifyDataSetChanged()
    }
}
