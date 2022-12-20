package menu

import menu.domain.Category
import menu.domain.Menu
import menu.domain.Menus
import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `못 먹는 음식을 제거힌디`() {
        val category = Category.KOREAN
        val menus = listOf("김밥").map { menu -> Menu(menu) }
        val actual = Menus(menus).removeMenu(category)
        val expected = listOf("김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        assertThat(actual).isEqualTo(expected)
    }
}