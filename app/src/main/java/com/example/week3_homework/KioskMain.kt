package com.example.week3_homework

fun main() {
    val ordered = mutableListOf<Order>()// 주문한 메뉴의 정보가 있는 Order 클래스
    val category = MainCategory()
    val billList = BillList(ordered)
    println("가진 돈을 입력하세요. 오류 발생 시 $ 100.0이 자동으로 입력됩니다.(소숫점 한자리까지)")
    var money = readln().toDoubleOrNull() ?: 100.0
    println("Welcome to Just Pizzeria")
    // 외부 반복문
    while (true) {
        // category
        category.printCategory(money)
        val menuType: MenuType = when (category.getCategory()) {
            0 -> {
                println("프로그램을 종료합니다.")
                break
            }

            1 -> PizzaMenu()
            2 -> DrinkMenu()
            3 -> SideMenu()
            9 -> {
                billList.printBill()
                continue
            }

            else -> continue
        }
        menuType.printMenu()
        val menuNum = menuType.getMenu()

        if (menuNum == 0) continue
        else ordered.add(menuType.takeNum(menuNum))

        if (menuType.nextOrder()) continue

        billList.printBill()
        when (billList.getNumFun()) {
            1 -> {
                money = billList.purchaseFun(money, ordered.sumOf { it.totalPrice })
                ordered.clear()
            }

            2 -> {
                ordered.clear()
            }

            3 -> {
                println("처음으로 돌아갑니다.")
            }
        }

    }
}
