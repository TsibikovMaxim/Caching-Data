package com.example.hammersystemstest.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PizzaItem(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
): Parcelable