package com.example.week3_homework

class SideMenu : MenuType() {
    override val menu = arrayOf(
        Menu("French Fries  ", 3.0, "바삭바삭 맛있는 감자튀김"),
        Menu("Buffalo Wing  ", 5.0, "날개만 좋아하는 당신에게"),
        Menu("Buffalo Stick ", 5.0, "봉만 좋아하는 당신에게"),
        //Triple("",10.0,"")
    )

    override fun printMenu() {
        val menu = menu
        println("아래 메뉴판에서 구매를 희망하는 번호를 입력하세요.")
        println("\n[ Side ]\n")
        for (i in menu.indices) {
            println("${i + 1}. ${menu[i].name}\t| \$ ${menu[i].price} | ${menu[i].introduce}")
        }
        println("0. 뒤로가기\t\t\t| 뒤로가기\n")
    }
}