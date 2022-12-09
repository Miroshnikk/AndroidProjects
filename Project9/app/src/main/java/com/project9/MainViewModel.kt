package com.project9

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
class MainViewModel(app:Application): AndroidViewModel(app) {
    var timerUpdates = MutableLiveData<Int>()
    var timerLength = 0
    private var timerStop = false

    suspend fun starTimer(){
        timerStop = false
        startCountDown()

    }
    private suspend fun startCountDown(){
        while (timerLength > 0){
            if (!timerStop){
                delay(1001)
                timerLength -= 1
                timerUpdates.postValue(timerLength)
            } else {
                break
            }
        }
    }

    suspend fun stopTime() {
        timerStop = !timerStop
        startCountDown()
    }

    fun reset() {
        timerStop = true
    }
}