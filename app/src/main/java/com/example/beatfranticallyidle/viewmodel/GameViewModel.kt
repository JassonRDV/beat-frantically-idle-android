package com.example.beatfranticallyidle.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beatfranticallyidle.model.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.collections.forEach

@HiltViewModel
class GameViewModel @Inject constructor(

) : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private var gameLoopJob: Job? = null

    init {
        startGameLoop()
    }

    private fun startGameLoop() {
        gameLoopJob?.cancel() // Cancel any existing job
        gameLoopJob = viewModelScope.launch {
            while (true) {
                delay(1000) // Runs every 1 second
                calculateDpsTick()
            }
        }
    }

    private fun calculateDpsTick() {
        val currentState = _gameState.value
        var totalDps = currentState.baseDps

        // Adds DPS all updates.
        currentState.upgrades.forEach { upgrade ->
            totalDps += upgrade.dpsBonus * upgrade.level.toBigDecimal()
        }

        _gameState.value = currentState.copy()
    }
}
