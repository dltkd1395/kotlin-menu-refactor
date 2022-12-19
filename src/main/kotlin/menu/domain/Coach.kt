package menu.domain

import menu.utils.ERROR
import menu.utils.ERROR_COACH_SIZE
import menu.utils.MAX_COACH_SIZE
import menu.utils.MIN_COACH_SIZE

class Coach {

    companion object {
        fun from(values: List<String>): List<CoachName> {
            val coaches = values.map { name ->
                CoachName(name)
            }
            require(isSize(coaches)) { ERROR.format(ERROR_COACH_SIZE) }
            return coaches
        }

        private fun isSize(values: List<CoachName>): Boolean =
            values.size in MIN_COACH_SIZE..MAX_COACH_SIZE
    }
}