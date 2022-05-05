package com.example.hammersystemstest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hammersystemstest.adapters.PizzaAdapter
import com.example.hammersystemstest.databinding.FragmentListBinding
import com.example.hammersystemstest.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding?= null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        val restaurantAdapter = PizzaAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.data.observe(viewLifecycleOwner) { result ->
                restaurantAdapter.submitList(result.data?.data)

                progressBar.isVisible = result is Resource.Loading && result.data?.data.isNullOrEmpty()
                errorTextView.isVisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
                errorTextView.text = result.error?.localizedMessage
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}