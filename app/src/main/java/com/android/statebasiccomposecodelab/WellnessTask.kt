package com.android.statebasiccomposecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.statebasiccomposecodelab.ui.theme.StateBasicComposeCodelabTheme

data class WellnessTask(val id: Int, val label: String)

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(list: List<WellnessTask>, modifier: Modifier, onCloseTask: (WellnessTask) -> Unit) {
    LazyColumn{
        items(items = list, key = { task -> task.id }) { task ->
            WellnessTaskItem(taskName = task.label, modifier = modifier, onClose = { onCloseTask.invoke(task) })
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
            onCloseTask = {})
    }
}