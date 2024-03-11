package com.example.week3_homework

abstract class MenuType {
    abstract val menu: Array<Triple<String, Double, String>>
    abstract fun printMenu()
    abstract fun takeNum(num: String, ordered: Array<Order>): Boolean //메뉴 이름, 가격, 개수 총합
}