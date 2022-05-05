package com.example.hammersystemstest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.hammersystemstest.databinding.FragmentItemBinding

class ItemFragment : Fragment() {

    private var _binding: FragmentItemBinding?= null
    private val binding get() = _binding!!

    private val args by navArgs<ItemFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater, container, false)

        binding.apply {
            Glide.with(requireContext())
                .load(args.currentItem.avatar)
                .into(imageViewItem)

            textViewNameItem.text = args.currentItem.first_name + " " + args.currentItem.last_name
            textViewEmailItem.text = args.currentItem.email
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}