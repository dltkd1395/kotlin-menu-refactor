package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_MENU_COUNT
import menu.utils.MAX_MENU_COUNT
import menu.utils.MIN_MENU_COUNT

class Menus(private val menus: List<Menu>) {

    init {
        require(isMenuCount()) { ERROR.format(ERROR_MENU_COUNT) }
    }

    fun removeMenu(category: Category): List<Menu> {
        var categoryMenus = category.foods.toMutableList()
        for (menu in menus) {
            categoryMenus = removeCategoryMenus(categoryMenus, menu)
        }
        return categoryMenus.map { food ->
            Menu(food)
        }
    }

    private fun removeCategoryMenus(
        categoryMenus: MutableList<String>,
        menu: Menu
    ): MutableList<String> {
        if (categoryMenus.contains(menu.toString())) {
            categoryMenus.remove(menu.toString())
        }
        return categoryMenus
    }

    private fun isMenuCount(): Boolean =
        menus.size in MIN_MENU_COUNT..MAX_MENU_COUNT

    override fun toString(): String =
        menus.map(Menu::toString).joinToString(" | ")
}