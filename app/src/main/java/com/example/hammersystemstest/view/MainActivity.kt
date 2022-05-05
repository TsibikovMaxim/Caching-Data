package com.example.hammersystemstest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hammersystemstest.databinding.ActivityMainBinding
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.findNavController
import com.example.hammersystemstest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setupActionBarWithNavController(findNavController(R.id.fragment_container))

    }
}