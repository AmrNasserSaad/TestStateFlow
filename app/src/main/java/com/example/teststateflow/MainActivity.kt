package com.example.teststateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var timerViewModel: TimerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textv)
        timerViewModel.startTimer()


        lifecycleScope.launch {
            timerViewModel.timerStateFlow.collect {
                textView.text = it.toString()
                Log.d("here", it.toString())
            }
        }
    }
}