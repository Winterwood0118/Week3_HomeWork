package com.example.week3_homework

import kotlin.math.round

class BillList(_ordered: MutableList<Order>) {
    val ordered = _ordered
    fun printBill() {
        if (ordered.isEmpty()) {
            println("주문 목록이 비어있습니다.")
        } else {
            println("순번\t|  품목 명\t\t\t|  가격\t\t| 개수\t| 총가격")
            for (i in 0..ordered.lastIndex) {
                println("${i + 1}\t| ${ordered[i].name}\t|  $ ${ordered[i].price}\t| ${ordered[i].countOfOrder}  \t| $ ${ordered[i].totalPrice}")
            }
            println("총 금액\t\t\t\t\t\t\t\t\t\t| $ ${ordered.sumOf { it.totalPrice }}")
        }
    }

    fun getNumFun(): Int {
        println("\n사용하실 기능을 선택해주세요.")
        println("1.\t결제하기\t2.\t초기화하기\t3.\t처음으로 돌아가기")
        while (true) {
            val input = readln().toIntOrNull() ?: -1
            when (input) {
                1, 2, 3 -> return input
                else -> {
                    println("올바른 숫자를 입력해주세요.")
                }
            }
        }
    }

    fun purchaseFun(_money: Double, total: Double): Double {
        var money = _money

        if (money >= total) {
            val changes = round((money - total) * 10) / 10
            println("총 $ ${money} 중 $ ${total}을 지불해 $ ${changes} 남았습니다.")
            money -= total
        } else {
            val changes = round((-money + total) * 10) / 10
            println("금액이 $ ${changes}만큼 모자랍니다.")
        }

        return money
    }

}