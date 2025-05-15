package com.example.bmiextended.ui.shoppingList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmiextended.adapter.ShoppingListAdapter
import com.example.bmiextended.databinding.FragmentShoppingListBinding

class ShoppingListFragment : Fragment() {
    private var _binding: FragmentShoppingListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingListViewModel by viewModels()
    private lateinit var adapter: ShoppingListAdapter

    override fun onCreateView(inflater: LayoutInflater, c: ViewGroup?, b: Bundle?) =
        FragmentShoppingListBinding.inflate(inflater, c, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ShoppingListAdapter(emptyList()) { pos ->
            viewModel.toggleItemChecked(pos)
        }
        binding.shoppingRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.shoppingRecyclerView.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) { adapter.updateList(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
