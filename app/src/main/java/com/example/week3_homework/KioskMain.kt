package com.example.week3_homework

import java.time.LocalTime
import kotlin.concurrent.thread
// 예외처리 대부분 클래스로 이관
fun main() {
    val ordered = mutableListOf<Order>()// 주문한 메뉴의 정보가 있는 Order 클래스
    val category = MainCategory()
    val billList = BillList(ordered)
    var kioskFinished = false // 주문 대기수 thread 종료용

    println("가진 돈을 입력하세요. 오류 발생 시 $ 100.0이 자동으로 입력됩니다.(소숫점 한자리까지)")
    var money = readln().toDoubleOrNull() ?: 100.0
    println("Welcome to Just Pizzeria")
    // 돈 입력할 때 까지 thread 실행 안함
    val kioskThread = thread(false) {
        // 키오스크 기능 전체 반복문
        while (true) {
            // category 선택하기
            category.printCategory(money)
            // 아래 menuType은 스튜디오에서 추천해서 바꿔본 선언방식
            val menuType = when (category.getCategory()) {
                0 -> {
                    kioskFinished = true
                    break
                }

                1 -> {
                    PizzaMenu()
                }

                2 -> {
                    DrinkMenu()
                }

                3 -> {
                    SideMenu()
                }

                9 -> {
                    billList.printBill()
                    continue
                }
                // 예외처리를 getCategory 메서드에서 했지만 외부에서는 그것을 알 방법이 없으니 else문을 작성하여야 레드라인이 안나온다
                else -> {
                    continue
                }
            }
            //해당 카테고리의 메뉴 출력 후 번호 및 개수 입력 받기
            menuType.printMenu()
            val menuNum = menuType.getMenu()
            // 0 입력 시 처음화면으로, 다른 숫자 입력 시 주문목록에 추가
            if (menuNum == 0) continue
            else ordered.add(menuType.takeNum(menuNum))
            // 추가 주문 여부 확인
            if (menuType.nextOrder()) continue
            // 주문 목록 기능
            billList.printBill()
            when (billList.getNumFun()) {
                1 -> {
                    //시간 체크기능
                    val whatTimeIsItNow = LocalTime.now()
                    if (whatTimeIsItNow.hour == 23 && whatTimeIsItNow.minute in 50..59) {
                        println("23시 50분부터 23시 59분까지는 은행 점검 시간입니다. 처음으로 돌아갑니다.")
                        continue
                    } else {
                        money = billList.purchaseFun(money, ordered.sumOf { it.totalPrice })
                        ordered.clear()
                        // 추가 주문 여부 확인: 1 입력 시 처음 화면으로 2 입력시 반복문 종료
                        if (menuType.nextOrder()) continue
                        else {
                            kioskFinished = true
                            break
                        }
                    }
                }

                2 -> {
                    ordered.clear()
                    continue
                }

                3 -> {
                    println("처음으로 돌아갑니다.")
                    continue
                }
            }
        }
    }
    val orderedThread = thread(false) {
        //10초마다 주문 대기열 증가 / 주문 대기열 출력
        var i = 0
        Thread.sleep(50)
        while (true) {
            if (kioskFinished) break
            println("현재 주문 대기 수: ${i}건")
            i++
            Thread.sleep(5000)
        }
        println("프로그램을 종료합니다.")
    }
    orderedThread.start()
    kioskThread.start()
}
