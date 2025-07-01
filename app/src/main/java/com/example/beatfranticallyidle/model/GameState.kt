package com.example.beatfranticallyidle.model

import java.math.BigDecimal
import java.math.BigInteger

data class GameState(
    var currentGold: BigDecimal = BigDecimal.ZERO,
    var baseDps: BigDecimal = BigDecimal.ONE,
    val upgrades: MutableList<Upgrade> = mutableListOf(),
    var maxEnemyHealth: BigInteger = BigInteger.valueOf(100),
    var enemiesDefeated: Int = 0,
)

data class Upgrade(
    val id: String,
    val name: String,
    val baseCost: BigDecimal,
    val dpsBonus: BigDecimal,
    var level: Int = 0,
    var currentCost: BigDecimal = baseCost,
) {
    fun levelUp(): BigDecimal {
        return baseCost * BigDecimal("1.15").pow(level)
    }
}


