package com.example.hammersystemstest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class ApiModel (
    @PrimaryKey(autoGenerate = true)
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<PizzaItem> ?= null,
    val support: Support
)