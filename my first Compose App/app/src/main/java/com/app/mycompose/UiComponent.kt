package com.app.mycompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import javax.inject.Inject

open class UiComponent @Inject constructor() {
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        var expanded by rememberSaveable { mutableStateOf(false) }
        val extraPadding = if (expanded) 48.dp else 0.dp
        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier.padding(4.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {
                    Text(text = "Hello ")
                    Text(text = name)
                }
                ElevatedButton(onClick = {
                    expanded = !expanded
                }) {
                    Text(if (expanded) "show less" else "Show more")
                }
            }
        }

    }

    @Composable
    fun Greetings(
        modifier: Modifier = Modifier,
        names: List<String> = List(1000) { "$it"}
    ) {
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)){
            items(items = names){
                    name -> Greeting(name = name)
            }
        }
    }
    @Composable
    fun OnboardingScreen(onContinueClicked : () -> Unit ,modifier: Modifier = Modifier) {


        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcom to the Basics Codelab!")
            Button(modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked

            ) {
                Text("Continue")
            }
        }
    }
}