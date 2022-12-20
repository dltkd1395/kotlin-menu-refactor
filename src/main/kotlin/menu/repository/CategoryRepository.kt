package menu.repository

import menu.domain.Category

object CategoryRepository {
    val weekCategory = mutableListOf<Category>()

    fun add(category: Category) {
        weekCategory.add(category)
    }
}