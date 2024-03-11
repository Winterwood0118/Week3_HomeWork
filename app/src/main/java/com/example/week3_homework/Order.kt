package com.example.week3_homework

class Order(_name: String, _price: Double, _count: Int) {
    private val name = _name
    private val price = _price
    private val countOfOrder = _count
    private val totalPrice = price * countOfOrder
}