package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_CONTAIN_MENU

data class Menu(val name: String) {

    init {
        require(isContainsMenu()) { ERROR.format(ERROR_CONTAIN_MENU) }
    }

    fun isSameMenu(other: String): Boolean =
        name == other

    private fun isContainsMenu(): Boolean {
        for (category in Category.values()) {
            if (category.foods.contains(name)) {
                return true
            }
        }
        return false
    }

    override fun toString(): String =
        this.name
}