package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_CONTAIN_MENU

class Menu(private val name: String) {

    init {
        require(isContainsMenu()) { ERROR.format(ERROR_CONTAIN_MENU) }
    }

    private fun isContainsMenu(): Boolean {
        for (category in Category.values()) {
            if (!category.foods.contains(name)) {
                return false
            }
        }
        return true
    }


    override fun toString(): String =
        this.name
}