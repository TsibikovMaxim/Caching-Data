package com.example.hammersystemstest.view

import androidx.lifecycle.*
import com.example.hammersystemstest.data.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    repository: PizzaRepository
) : ViewModel() {

    val data = repository.getData().asLiveData()
}