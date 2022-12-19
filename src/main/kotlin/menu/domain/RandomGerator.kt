package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.utils.MAX_RANDOM_NUMBER
import menu.utils.MIN_RANDOM_NUMBER

class RandomGerator: NumberGenerator {
    override fun gerator(): Int =
        Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
}