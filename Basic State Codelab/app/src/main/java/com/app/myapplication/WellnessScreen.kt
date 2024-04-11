package com.app.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WellnessScreen(modifier : Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()){

    Column(modifier = modifier) {
        StatefulCounter()

        val list = wellnessViewModel.tasks
        WellnessTaskList(list= list ,
            onCheckedTask = {
                            task, checked-> wellnessViewModel.changeTaskChecked(task,checked)
            },
            onCloseTask = {task -> wellnessViewModel.remove(task)})
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }