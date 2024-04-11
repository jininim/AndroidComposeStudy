package com.app.myapplication

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun WellnessTaskList(
    list : List<WellnessTask>,
    onCheckedTask: (WellnessTask,MutableState<Boolean>) -> Unit,
    onCloseTask : (WellnessTask) -> Unit,
    modifier :Modifier = Modifier,
){
    LazyColumn(modifier = modifier) {
        items(items = list,
            key = {task -> task.id}
        ){
            task -> WellnessTaskItem(taskName = task.label , onClose = {onCloseTask(task)})
        }
    }
}