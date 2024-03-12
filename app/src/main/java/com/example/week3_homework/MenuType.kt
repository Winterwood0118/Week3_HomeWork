package com.example.week3_homework

open class MenuType {
    open val menu: Array<Triple<String, Double, String>> = arrayOf()
    open fun printMenu() {}

    fun getMenu(): Int {
        val menuNum: Int
        while (true) {
            val input = readln().toIntOrNull() ?: -1
            when (input) {
                in 0..menu.size -> {
                    menuNum = input
                    break
                }

                else -> {
                    println("올바른 숫자를 입력해 주세요.")
                    continue
                }
            }
        }
        return menuNum
    }

    fun takeNum(_num: Int): Order { //메뉴 이름, 가격, 개수, 총합
        val num = _num
        val menu = menu
        val count: Int
        while (true) {
            println("구매할 수량을 입력해주세요. (최대 구매수량 10개)")
            val input = readln().toIntOrNull() ?: -1
            when (input) {
                0 -> {
                    println("0개는 구매할 수 없습니다.")
                    continue
                }

                in 1..10 -> {
                    count = input
                    break
                }

                else -> {
                    println("올바른 수량을 입력해주세요.")
                    continue
                }
            }
        }
        val order = Order(menu[num - 1].first, menu[num - 1].second, count)
        return order
    }

    fun nextOrder(): Boolean {
        while (true) {
            println("추가 구매를 진행하시겠습니까?")
            println("1. 추가로 구매하기\t 2. 계산하기")
            val input = readln()
            return when (input) {
                "1" -> true
                "2" -> false

                else -> {
                    println("올바른 숫자를 입력해주세요.")
                    continue
                }
            }
        }
    }
}

