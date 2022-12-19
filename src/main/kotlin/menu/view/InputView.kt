package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.domain.CoachName
import menu.utils.INPUT_COACHES
import menu.utils.INPUT_MENU_RECOMMEND


object InputView {
    fun readCoaches(): List<CoachName> {
        println(INPUT_MENU_RECOMMEND)
        println(INPUT_COACHES)
        return Coach.from(Console.readLine().split(", "))
    }
}