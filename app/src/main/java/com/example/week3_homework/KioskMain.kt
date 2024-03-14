package com.example.week3_homework

// 예외처리 대부분 클래스로 이관
fun main() {
    val countThread = CountThread()
    val ordered = mutableListOf<Order>()// 주문한 메뉴의 정보가 있는 Order 클래스
    val category = MainCategory()
    val billList = BillList(ordered)

    println("가진 돈을 입력하세요. 오류 발생 시 $ 100.0이 자동으로 입력됩니다.(소숫점 한자리까지)")
    var money = readln().toDoubleOrNull() ?: 100.0
    println("Welcome to Just Pizzeria")

    // 돈 입력후 5초마다 자동으로 출력하는 thread
    countThread.start()

    // 키오스크 기능 전체 반복문
    while (true) {
        // category 선택하기
        category.printCategory(money)

        val menuType = when (category.getCategory()) {
            0 -> break
            1 -> PizzaMenu()
            2 -> DrinkMenu()
            3 -> SideMenu()
            9 -> {
                billList.printBill()
                continue
            }
            // 예외처리를 getCategory 메서드에서 했지만 외부에서는 그것을 알 방법이 없으니 else문을 작성하여야 레드라인이 안나온다
            else -> continue
        }
        println("메뉴판을 불러오는 중")
        Thread.sleep(3000)
        //해당 카테고리의 메뉴 출력 후 번호 및 개수 입력 받기
        menuType.printMenu()
        val menuNum = menuType.getMenu()

        // 0 입력 시 처음화면으로, 다른 숫자 입력 시 주문목록에 추가
        if (menuNum == 0) continue
        else ordered.add(menuType.takeNum(menuNum))

        // 추가 주문 여부 확인: 1 입력 시 처음으로 2 입력시 반복문 종료
        if (menuType.nextOrder()) {
            println("추가 주문을 선택했습니다.")
            Thread.sleep(3000)
            continue
        }

        // 주문 목록 출력, 선택지 출력
        println("주문 목록을 불러오는 중")
        Thread.sleep(3000)
        billList.printBill()
        when (billList.getNumFun()) {
            1 -> {
                //시간 체크기능(전역변수 이용)
                if (localDateTime.hour == 23 && localDateTime.minute in 50..59) {
                    println("23시 50분부터 23시 59분까지는 은행 점검 시간입니다. 처음으로 돌아갑니다.")
                } else {
                    money = billList.purchaseFun(money, ordered.sumOf { it.totalPrice })
                    ordered.clear()

                    // 추가 주문 여부 확인: 1 입력 시 처음으로 2 입력시 반복문 종료
                    if (!menuType.nextOrder()) break
                }
            }
            2 -> {
                ordered.clear()
            }
            3 -> println("처음으로 돌아갑니다.")
        }
        println("메뉴판을 불러오는 중")
        Thread.sleep(3000)
        continue
    }// 키오스크 while문 끝

    println("잠시 후 프로그램이 종료됩니다.")
    countThread.kioskFinished = true
}

