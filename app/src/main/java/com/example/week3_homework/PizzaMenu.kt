package com.example.week3_homework

class PizzaMenu : MenuType() {
    override val menu = arrayOf(
        Triple("Pepperoni Pizza", 12.0, "근본의 피자"),
        Triple("Cheese Pizza  ", 12.3, "6가지 치즈가 들어가 풍부한 맛"),
        Triple("Bulgogi Pizza ", 15.0, "단짠 석쇠 불고기가 들어간 피자"),
        Triple("Hawaiian Pizza", 29.9, "왜 안파냐는 문의가 너무 많아 만든 인기 절정의 피자")
    )

    override fun printMenu() {
        val menu = menu
        println("아래 메뉴판에서 구매를 희망하는 번호를 입력하세요.")
        println("\n[ Pizza ]\n")
        for (i in menu.indices) {
            println("${i + 1}. ${menu[i].first}\t| $ ${menu[i].second} | ${menu[i].third}")
        }
        println("0. 뒤로가기\t\t\t| 뒤로가기\n")
    }
}