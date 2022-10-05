package com.android.statebasiccomposecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.statebasiccomposecodelab.ui.theme.StateBasicComposeCodelabTheme

data class WellnessTask(val id: Int, val label: String, var checkedState: MutableState<Boolean> = mutableStateOf(false))

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(list: List<WellnessTask>, modifier: Modifier, onCloseTask: (WellnessTask) -> Unit, onStateChange: (WellnessTask, Boolean) -> Unit) {
    LazyColumn{
        items(items = list, key = { task -> task.id }) { task ->
            WellnessTaskItem(
                taskName = task.label,
                modifier = modifier,
                onClose = { onCloseTask.invoke(task) },
                checked = task.checkedState.value, onCheckedChange = { isChecked ->
                onStateChange.invoke(task, isChecked)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview(){

    StateBasicComposeCodelabTheme{
        WellnessTasksList(
            list = getWellnessTasks(),
            modifier = Modifier,
            onCloseTask = {},
            onStateChange = {_, _ -> }
        )
    }
}