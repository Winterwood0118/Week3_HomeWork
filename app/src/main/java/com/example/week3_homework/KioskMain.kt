package com.example.week3_homework


/* 기본 기능
1. 메뉴 카테고리(대분류)
2. 메뉴 선택(메뉴 리스트)
3. 선택한 메뉴 주문 리스트에 추가
4. 결제 확인창(추가로 주문하기, 주문 취소하기, 결제하기) << 안됐음
 */
/* 추가할 기능
1. 번호 골라서 주문 취소하기
2. 시간 관련
 */
fun main() {
    val ordered = mutableListOf<Order>()// 주문한 메뉴의 정보가 있는 Order 클래스
    val category = MainCategory()
    val billList = BillList(ordered)
    println("가진 돈을 입력하세요. 오류 발생 시 $ 100.0이 자동으로 입력됩니다.(소숫점 한자리까지)")
    var money = readln().toDoubleOrNull() ?: 100.0
    println("Welcome to Just Pizzeria\n")
    order@ while (true) {
        val menuType: MenuType
        category.printCategory()
        while (true) {
            val input = readln()
            when (input) {
                "0" -> {
                    println("프로그램을 종료합니다.")
                    break@order
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

                "9" -> {
                    if (ordered.isEmpty()) {
                        println("주문목록이 비었습니다.")
                    } else {
                        billList.printBill()
                        while (true) {
                            billList.printFun()
                            val input2 = readln()
                            when (input2) {
                                "1" -> {
                                    money =
                                        billList.purchaseFun(money, ordered.sumOf { it.totalPrice })
                                    continue@order
                                }

                                "2" -> {
                                    println("주문목록을 초기화합니다.")
                                    ordered.clear()
                                    continue@order
                                }

                                "3" -> {
                                    println("처음으로 돌아갑니다.")
                                    continue@order
                                }

                                else -> {
                                    println("올바른 숫자를 선택하세요")
                                    continue
                                }
                            }
                        }
                    }
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

        billList.printBill()
        while (true) {
            billList.printFun()
            val input = readln()
            when (input) {
                "1" -> {
                    money = billList.purchaseFun(money, ordered.sumOf { it.totalPrice })
                    continue@order
                }

                "2" -> {
                    println("주문목록을 초기화합니다.")
                    ordered.clear()
                    continue@order
                }

                "3" -> {
                    println("처음으로 돌아갑니다.")
                    continue@order
                }

                else -> {
                    println("올바른 숫자를 선택하세요")
                    continue
                }
            }
        }
    }

}