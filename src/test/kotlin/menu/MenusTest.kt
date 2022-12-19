package menu

import menu.domain.Menu
import menu.domain.Menus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenusTest {
    @Test
    fun `못 먹는 메뉴 개수가 0개에서 2개 사이가 아닌 경우 예외가 발생한다`() {
        val menus = listOf("우동", "스시", "라멘").map { menu -> Menu(menu) }
        assertThrows<IllegalArgumentException> {
            Menus(menus)
        }
    }
}