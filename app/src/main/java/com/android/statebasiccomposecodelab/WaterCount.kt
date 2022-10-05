package com.android.statebasiccomposecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.statebasiccomposecodelab.ui.theme.StateBasicComposeCodelabTheme

@Composable
fun WaterCount(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "You've had $count glasses", )
        Button(onClick = { count++ }, Modifier.padding(8.dp) ) {
            Text(text = "Add one")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaterCountPreview() {
    StateBasicComposeCodelabTheme{
        WaterCount()
    }
}