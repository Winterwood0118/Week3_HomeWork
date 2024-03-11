package com.example.week3_homework

import kotlin.math.round

class Order(_name: String, _price: Double, _count: Int) {
    val name = _name
    val price = _price
    val countOfOrder = _count
    val totalPrice = round(price * countOfOrder * 10) / 10
}