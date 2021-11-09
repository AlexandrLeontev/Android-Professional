package com.example.dictonary.stopwatch.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictonary.R
import com.example.dictonary.databinding.ActivityStopwatchBinding
import com.example.dictonary.stopwatch.domain.*
import com.example.dictonary.stopwatch.domain.model.TimestampMillisecondsFormatter
import com.example.dictonary.stopwatch.viewmodel.StopWatchViewModel
import com.example.dictonary.stopwatch.viewmodel.StopWatchViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StopwatchActivity : AppCompatActivity() {

    private val binding: ActivityStopwatchBinding by viewBinding()
    private val timestampProvider: ITimestampProvider = TimestampProviderImpl()
    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val viewModel: StopWatchViewModel by viewModels {
        StopWatchViewModelFactory(
            StopwatchStateHolder(
                StopwatchStateCalculator(
                    timestampProvider,
                    ElapsedTimeCalculator(timestampProvider),
                ),
                ElapsedTimeCalculator(timestampProvider),
                TimestampMillisecondsFormatter()
            ),
            CoroutineScope(Dispatchers.Main + SupervisorJob())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        scope.launch {
            viewModel.ticker.collect {
                binding.textTimeOne.text = it
            }
        }
    }

    private fun init() {
        binding.buttonStartOne.setOnClickListener {
            viewModel.start()
        }
        binding.buttonPauseOne.setOnClickListener {
            viewModel.pause()
        }
        binding.buttonStopOne.setOnClickListener {
            viewModel.stop()
        }
    }
}