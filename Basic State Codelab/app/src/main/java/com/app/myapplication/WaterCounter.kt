package com.app.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(count :Int , onIncrement : () -> Unit,modifier: Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0){
            Text("you've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp)) {
            Text("Add One")
        }
    }
}

@Preview
@Composable
fun StatefulCounter(modifier : Modifier = Modifier){
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    StatelessCounter(count = count, onIncrement = {count++}, modifier = modifier)
}







/*fun WaterCounter(modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Column(modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        if (count > 0) {
            var showTask by rememberSaveable {
                mutableStateOf(true)
            }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false })
            }
            Text(
                text = "you've had $count glasses.",
            )
        }
        Row(modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add One")
            }
            Button(
                onClick = { count = 0 },
                modifier.padding(start = 8.dp)) {
                Text("Clear water count")
            }
        }

    }

}*/

