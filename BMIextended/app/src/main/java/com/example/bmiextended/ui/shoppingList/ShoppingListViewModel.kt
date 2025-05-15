package com.example.bmiextended.ui.shoppingList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmiextended.model.ShoppingItem

class ShoppingListViewModel : ViewModel() {
    private val _items = MutableLiveData(
        listOf(
            ShoppingItem("Mleko"),
            ShoppingItem("Chleb"),
            ShoppingItem("Jajka")
        )
    )
    val items: LiveData<List<ShoppingItem>> = _items

    fun toggleItemChecked(position: Int) {
        val updated = _items.value?.toMutableList() ?: return
        val item = updated[position]
        updated[position] = item.copy(isChecked = !item.isChecked)
        _items.value = updated
    }
}
