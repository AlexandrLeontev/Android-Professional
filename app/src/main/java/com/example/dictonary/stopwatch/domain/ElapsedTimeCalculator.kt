package com.example.dictonary.stopwatch.domain

import com.example.dictonary.stopwatch.domain.model.StopwatchState

class ElapsedTimeCalculator(
    private val timestampProvider: ITimestampProvider,
) {

    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}