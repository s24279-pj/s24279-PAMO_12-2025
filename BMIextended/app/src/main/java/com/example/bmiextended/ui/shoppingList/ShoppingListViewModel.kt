package com.example.bmiextended.ui.shoppingList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmiextended.model.ShoppingItem

class ShoppingListViewModel : ViewModel() {
    private val _items = MutableLiveData<List<ShoppingItem>>(
        listOf(
            ShoppingItem("Feta cheese"),
            ShoppingItem("Olives"),
            ShoppingItem("Tomatoes"),
            ShoppingItem("Cucumber"),
            ShoppingItem("Onion"),
            ShoppingItem("Olive oil")
        )
    )
    val items: LiveData<List<ShoppingItem>> = _items

    fun toggleItemChecked(index: Int) {
        val updated = _items.value?.toMutableList() ?: return
        val item = updated[index]
        updated[index] = item.copy(isChecked = !item.isChecked)
        _items.value = updated
    }
}
