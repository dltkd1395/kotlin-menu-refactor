package menu.domain

import menu.utils.*

enum class Category(val number: Int, val value: String, val foods: List<String>) {
    JAPANESE(1, "일식", JAPANESE_FOOD.split(", ")),
    KOREAN(2, "한식", KOREAN_FOOD.split(", ")),
    CHINESE(3, "중식", CHINESE_FOOD.split(", ")),
    ASIAN(4, "아시안", ASIAN_FOOD.split(", ")),
    WESTERN(5, "양식", WESTERN_FOOD.split(", "));

    companion object {
        fun of(otherNumbewr: Int): Category =
            values().find { category ->
                category.number.equals(otherNumbewr)
            } ?: throw IllegalArgumentException(ERROR.format(ERROR_FIND_CATEGORY))
    }
}