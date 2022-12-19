package menu

import menu.domain.Menu
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuTest {
    @Test
    fun `못 먹는 메뉴에서 포함되지 않는 메뉴를 입력한 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Menu("족발")
        }
    }
}