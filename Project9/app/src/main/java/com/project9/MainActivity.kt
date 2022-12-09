package com.project9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.project9.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonStart.setOnClickListener {
            viewModel.timerLength = binding.etTimerLength.text.toString().toInt()
            binding.TimerResult.text = binding.etTimerLength.text.toString()
            GlobalScope.launch(Dispatchers.Main) { viewModel.starTimer() }
            viewModel.timerUpdates.observe(this) {
                it?.let {
                    binding.TimerResult.text = it.toString()
                }
            }
        }

        binding.buttonStop.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) { viewModel.stopTime() }
        }

        binding.buttonReset.setOnClickListener {
            viewModel.timerLength = 0
            binding.TimerResult.text = "0"
            GlobalScope.launch(Dispatchers.Main) { viewModel.reset() }
        }


    }
}