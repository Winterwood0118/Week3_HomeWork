package com.example.week3_homework

import kotlin.math.round

data class Order(val name: String, val price: Double, val count: Int) {
    val totalPrice = round(price * count * 10) / 10
}