package menu

import menu.domain.Coach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CoachTest {
    @Test
    fun `코치가 2명에서 5명 사이가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Coach.from(listOf("나비"))
        }
    }
}