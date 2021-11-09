package com.example.dictonary.stopwatch.domain

interface ITimestampProvider {
    fun getMilliseconds(): Long
}