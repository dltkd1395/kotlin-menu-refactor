package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.CoachName
import menu.domain.Menu
import menu.domain.Menus
import menu.repository.CategoryRepository
import menu.repository.MenuRepository
import menu.view.InputView

class RecommendService {

    private val categoryRepository = CategoryRepository
    private val menuRepository = MenuRepository
    private var weekendMenus = mutableMapOf<CoachName, MutableList<List<String>>>()

    fun recommmendMenu(coaches: List<CoachName>) {
        for (coach in coaches) {
            val menus = InputView.readMenus(coach)
            weekendMenus[coach] = mutableListOf()
            removeMenus(menus, coach)
        }
        addCoachMenus(coaches)
    }

    private fun removeMenus(menus: Menus, coach: CoachName) {
        for (categoty in categoryRepository.weekCategory) {
            val foods = menus.removeMenu(categoty)
            weekendMenus[coach]?.add(foods)
        }
    }

    private fun addCoachMenus(coaches: List<CoachName>) {
        for (i in 0 until 5) {
            for (coach in coaches) {
                addRandomMenu(coach, weekendMenus[coach]?.get(i) ?: listOf())
            }
        }
    }

    private fun addRandomMenu(coach: CoachName, foods: List<String>) {
        while (true) {
            val menu = Menu(Randoms.shuffle(foods)[0])
            if (!menuRepository.contain(coach, menu)) {
                menuRepository.add(coach, menu)
                break
            }
        }
    }
}