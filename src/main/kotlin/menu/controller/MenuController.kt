package menu.controller

import menu.domain.*
import menu.repository.CategoryRepository
import menu.service.RecommendService
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
        var tryNumber = 0
        while (tryNumber < 5) {
            val category = Category.of(RandomGerator().gerator())
            if (!isSameCategorySize(category)) {
                categoryRepository.add(category)
                tryNumber++
            }
        }
    }

    private fun isSameCategorySize(category: Category): Boolean {
        val size = categoryRepository.weekCategory
            .filter { otherCategory -> otherCategory.equals(category) }
            .size
        if (size >= 2) {
            return true
        }
        return false
    }
}


