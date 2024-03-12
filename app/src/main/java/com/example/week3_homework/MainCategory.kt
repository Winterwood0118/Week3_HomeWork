package com.example.week3_homework

class MainCategory {
    fun printCategory(money: Double) {
        println("\n아래 메뉴판에서 해당하는 카테고리의 번호를 입력하세요.\n")
        println("[ Choice Foods or Drinks ]\t 잔액 : $ $money \n")
        println("1.\tPizza\t\t| 쫄깃한 도우에 다양한 토핑")
        println("2.\tDrink\t\t| 석박사의 노력이 담긴 맛")
        println("3.\tSide\t\t| 피자와 어울리는 다양한 사이드")
        println("9.\tBill\t\t| 주문목록 확인하기")
        println("0.\tFinish\t\t| 프로그램 종료")
    }

    fun getCategory(): Int {
        while (true) {
            val input = readln().toIntOrNull() ?: -1
            when (input) {
                0, 1, 2, 3, 9 -> return input
                else -> {
                    println("올바른 숫자를 입력해 주세요.")
                    continue
                }
            }
        }
    }

}