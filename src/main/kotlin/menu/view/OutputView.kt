package menu.view

import menu.repository.CategoryRepository
import menu.repository.MenuRepository

import menu.utils.*

object OutputView {
    fun printResult() {
        println(OUTPUT_RESULT)
        println()
        println(OUTPUT_WEEKEND.format(WEEKEND.split(", ").joinToString(" | ")))
        printCategory()
        printCoachMenus()
        println("추천을 완료했습니다.")
    }

    private fun printCategory() {
        val weekend = CategoryRepository.weekCategory.map { it.value }.joinToString(" | ")
        println(OUTPUT_CATEGORY.format(CategoryRepository.weekCategory.map { it.value }.joinToString(" | ")))
    }

    private fun printCoachMenus() {
        MenuRepository.coacheMenus.map { (coach, menus) ->
            println(OUTPUT_COACH_MENUS.format(coach.toString(), menus.joinToString(" | ")))
        }
    }
}