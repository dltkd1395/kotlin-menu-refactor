package menu.domain

import menu.utils.*

enum class Category(val number: Int, val foods: List<String>) {
    JAPANESE(1, JAPANESE_FOOD.split(", ")),
    KOREAN(2, KOREAN_FOOD.split(", ")),
    CHINESE(3, CHINESE_FOOD.split(", ")),
    ASIAN(4, ASIAN_FOOD.split(", ")),
    WESTERN(5, WESTERN_FOOD.split(", "));

    companion object {
        fun of(otherNumbewr: Int): Category =
            values().find { category ->
                category.number.equals(otherNumbewr)
            } ?: throw IllegalArgumentException(ERROR.format(ERROR_CONTAIN_MENU))
    }
}