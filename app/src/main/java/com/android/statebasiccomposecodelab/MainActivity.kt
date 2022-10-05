package com.android.statebasiccomposecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.statebasiccomposecodelab.ui.theme.StateBasicComposeCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateBasicComposeCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel(),
) {
    val list = remember { wellnessViewModel.tasks }
    Column {
        StatefulWaterCounter()
        WellnessTasksList(
            list, modifier =
            modifier,
            onCloseTask = { wellnessViewModel.remove(it) },
            onStateChange = { task, state ->
                wellnessViewModel.changeTaskState(task, state)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateBasicComposeCodelabTheme {
        WellnessScreen()
    }
}