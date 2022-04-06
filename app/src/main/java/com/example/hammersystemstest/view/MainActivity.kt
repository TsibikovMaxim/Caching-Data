package com.example.hammersystemstest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hammersystemstest.adapters.PizzaAdapter
import com.example.hammersystemstest.databinding.ActivityMainBinding
import com.example.hammersystemstest.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title =  "Москва"

        val restaurantAdapter = PizzaAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            viewModel.data.observe(this@MainActivity) { result ->
                restaurantAdapter.submitList(result.data?.data)

                progressBar.isVisible = result is Resource.Loading && result.data?.data.isNullOrEmpty()
                errorTextView.isVisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
                errorTextView.text = result.error?.localizedMessage
            }
        }
    }
}