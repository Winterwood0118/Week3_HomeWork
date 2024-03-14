package com.example.week3_homework

class CountThread(): Thread() {
    var kioskFinished = false
    override fun run() {
        var i = 0
        sleep(50)
        while (!kioskFinished) {
            println("현재 주문 대기 수: ${i}건")
            i++
            sleep(5000)
        }
        println("프로그램을 종료합니다.")
    }
}