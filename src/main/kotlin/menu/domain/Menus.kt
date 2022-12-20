package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_MENU_COUNT
import menu.utils.MAX_MENU_COUNT
import menu.utils.MIN_MENU_COUNT

class Menus(private val menus: List<Menu>) {

    init {
        require(isMenuCount()) { ERROR.format(ERROR_MENU_COUNT) }
    }

    fun get(): List<Menu> =
        this.menus

    fun removeMenu(category: Category): List<String> {
        val categoryFoods = category.foods.toMutableList()
        categoryFoods.zip(menus)
            .map { (categoryMenu, menu) ->
                if (menu.isSameMenu(categoryMenu)) {
                    categoryFoods.remove(menu.name)
                }
            }
        return categoryFoods
    }

    private fun isMenuCount(): Boolean =
        menus.size in MIN_MENU_COUNT..MAX_MENU_COUNT
}