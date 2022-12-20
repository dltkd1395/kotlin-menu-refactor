package menu.controller

import menu.domain.*
import menu.repository.CategoryRepository
import menu.service.RecommendService
import menu.utils.MAX_CATEGORY_SIZE
import menu.utils.MAX_DAYS_NUMBER
import menu.utils.MIN_DAYS_NUMBER
import menu.view.InputView
import menu.view.OutputView

class MenuController {

    private val categoryRepository = CategoryRepository
    private val recommendService = RecommendService()

    fun run() {
        recommandMenu()
    }

    private fun recommandMenu() {
        val coaches = InputView.readCoaches()
        setCategoryMenus()
        recommendService.recommmendMenu(coaches)
        OutputView.printResult()
    }

    private fun setCategoryMenus() {
        var daysNumber = MIN_DAYS_NUMBER
        while (daysNumber < MAX_DAYS_NUMBER) {
            val category = Category.of(RandomGerator().gerator())
            if (!isSameCategorySize(category)) {
                categoryRepository.add(category)
                daysNumber++
            }
        }
    }

    private fun isSameCategorySize(category: Category): Boolean {
        val size = categoryRepository.weekCategory
            .filter { otherCategory -> otherCategory.equals(category) }
            .size
        if (size >= MAX_CATEGORY_SIZE) {
            return true
        }
        return false
    }
}


