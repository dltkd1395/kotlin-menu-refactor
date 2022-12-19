package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_NAME_LENGTH
import menu.utils.MAX_NAME_LENGTH
import menu.utils.MIN_NAME_LENGTH

class CoachName(private val value: String) {
    init {
        require(isNameLength()) { ERROR.format(ERROR_NAME_LENGTH) }
    }

    private fun isNameLength(): Boolean =
        value.length >= MIN_NAME_LENGTH && value.length <= MAX_NAME_LENGTH
}