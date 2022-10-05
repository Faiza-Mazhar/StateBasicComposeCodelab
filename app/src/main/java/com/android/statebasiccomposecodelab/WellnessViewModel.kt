package com.android.statebasiccomposecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel: ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()

    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskState(task: WellnessTask, checkedValue: Boolean) {
        _tasks.find { it.id == task.id }?.let { item ->
            item.checkedState.value = checkedValue
        }
    }
}