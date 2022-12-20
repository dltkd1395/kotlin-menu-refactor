package menu.repository

import menu.domain.CoachName
import menu.domain.Menu

object MenuRepository {
    val coacheMenus = mutableMapOf<CoachName, MutableList<Menu>>()

    fun add(coachName: CoachName, menu: Menu) {
        when (coacheMenus.containsKey(coachName)) {
            true -> coacheMenus[coachName]?.add(menu)
            false -> coacheMenus[coachName] = mutableListOf(menu)
        }

    }

    fun contain(coachName: CoachName, menu: Menu): Boolean =
        coacheMenus[coachName]?.contains(menu) ?: false

}