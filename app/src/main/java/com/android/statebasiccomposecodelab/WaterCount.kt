package com.android.statebasiccomposecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.statebasiccomposecodelab.ui.theme.StateBasicComposeCodelabTheme

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count = count, increment = { count++ }, modifier = modifier )
}

@Composable
fun StatelessCounter(count: Int, increment: () -> Unit, modifier: Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses")
        }

        Button(onClick = increment, enabled = count < 3, modifier = Modifier.padding(8.dp)) {
            Text(text = "Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCountPreview() {
    StateBasicComposeCodelabTheme {
        StatefulWaterCounter()
    }
}