package com.example.week3_homework

class DrinkMenu:MenuType() {
    override val menu = arrayOf(
        Triple("Soft Drink",2.1,"콜라 / 사이다 / 환타 선택 가능"),
        Triple("Milk Shake",3.5,"유명 햄버거집의 셰이크 싱크로율 96%"),
        Triple("Juice\t",3.0,"피자집에서 건강을 찾는 당신을 위한 음료"),
        Triple("Beer \t",4.0,"500ml, 피자에는 생맥주")
    )
    override fun printMenu() {
        val menu = menu
        println("아래 메뉴판에서 구매를 희망하는 번호를 입력하세요.\n")
        println("\n[ Drink ]\n")
        for (i in menu.indices) {
            println("${i+1}. ${menu[i].first}\t| $ ${menu[i].second} | ${menu[i].third}")
        }
        println("0. 뒤로가기\t\t| 뒤로가기")
    }
    override fun takeNum(num: String, ordered: Array<Order>) {
        TODO("Not yet implemented")
    }
}