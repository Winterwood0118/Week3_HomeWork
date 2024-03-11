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
    while (true) {
        println("Welcome to Just Pizzeria\n")
        val menuType: MenuType // 카테고리 이동용
        category.printCategory()
        while (true) {
            val input = readln()
            when (input) {
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

                else -> {
                    println("올바른 번호를 입력하세요.")
                    continue
                }
            }
        }
        menuType.printMenu()

        while (true) {
            val menuInput = readln()
            if(menuInput == "0") continue // 0을 입력하면 카테고리 선택화면으로
            try {
                menuType.takeNum(menuInput, ordered) // 주문 받고 개수 확인
            } catch (e: Exception) {
                println("올바른 번호를 입력하세요")
            }
        }


    }
}