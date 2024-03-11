package com.example.week3_homework

/*
1. 메뉴 카테고리(대분류)
2. 메뉴 선택(메뉴 리스트)
3. 선택한 메뉴 주문 리스트에 추가
4. 결제 확인창(추가로 주문하기, 주문 취소하기, 결제하기)
 */
fun main() {
    var ordered = arrayOf<Order>()// 주문한 메뉴의 정보가 있는 Order 클래스
    val category = MainCategory()
    println("Welcome to Just Pizzeria\n")
    order@ while (true) {
        val menuType: MenuType
        category.printCategory()
        while (true) {
            val input = readln()
            when (input) {
                "0" -> {
                    println("프로그램을 종료합니다.")
                    return
                }

                "1" -> {
                    menuType = PizzaMenu()
                    break
                }

                "2" -> {
                    menuType = DrinkMenu()
                    break
                }

                "3" -> {
                    menuType = SideMenu()
                    break
                }

                "7" -> {
                    println("순번\t|  품목 명\t\t\t|  가격\t\t| 개수\t| 총가격")
                    for (i in 0..ordered.lastIndex) {
                        println("${i + 1}\t| ${ordered[i].name}\t|  $ ${ordered[i].price}\t| ${ordered[i].countOfOrder}  \t| $ ${ordered[i].totalPrice}")
                    }
                    category.printCategory()
                }

                "8" -> {
                    ordered = arrayOf()
                    println("주문목록이 초기화 되었습니다.")
                    category.printCategory()
                }

                "9" -> {
                    if (ordered.isEmpty()) {
                        println("주문목록이 비어있습니다.")
                        category.printCategory()
                    } else break@order
                }

                else -> {
                    println("올바른 번호를 입력하세요.")
                }
            }
        } // 카테고리 선택
        menuType.printMenu()

        while (true) {
            try {
                when (val menuInput = readln().toInt()) {
                    0 -> continue@order// 0을 입력하면 카테고리 선택화면으로
                    in 1..menuType.menu.size -> {
                        ordered += menuType.takeNum(menuInput) // 주문 받고 개수 확인
                        break
                    }

                    else -> {
                        println("올바른 번호를 입력하세요")
                        continue
                    }
                }
            } catch (e: Exception) {
                println("올바른 번호를 입력하세요")
                continue
            }
        }
        val nextOrder = menuType.nextOrder()
        if (nextOrder) continue
        else break
    }
    // 주문 종료
    println("순번\t|  품목 명\t\t\t|  가격\t\t| 개수\t| 총가격")
    for (i in 0..ordered.lastIndex) {
        println("${i + 1}\t| ${ordered[i].name}\t|  $ ${ordered[i].price}\t| ${ordered[i].countOfOrder}  \t| $ ${ordered[i].totalPrice}")
    }
    val billPrice = ordered.sumOf { it.totalPrice }
    println("총 금액\t\t\t\t\t\t\t\t\t\t| $ ${billPrice}")
}