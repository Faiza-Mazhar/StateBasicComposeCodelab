package com.android.statebasiccomposecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.statebasiccomposecodelab.ui.theme.StateBasicComposeCodelabTheme

data class WellnessTask(val id: Int, val label: String)

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(list: List<WellnessTask> = remember { getWellnessTasks() }, modifier: Modifier) {
    LazyColumn{
        items(list) { task ->
            WellnessTaskItem(taskName = task.label, modifier = modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview(){
    StateBasicComposeCodelabTheme{
        WellnessTasksList(list = getWellnessTasks(), modifier = Modifier)
    }
}