package com.example.dictonary.stopwatch.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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

    private lateinit var binding: ActivityStopwatchBinding
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
        binding = ActivityStopwatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
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