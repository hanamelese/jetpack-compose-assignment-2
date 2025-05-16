//package com.example.todo.feature_todo.presentation.todo_list.components
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardColors
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.todo.feature_todo.domain.model.TodoItem
//import com.example.todo.ui.theme.TodoTheme
//
//@Composable
//fun TodoItemCard(
//    todo:TodoItem,
//    modifier: Modifier=Modifier,
//    onCardClick:()->Unit,
//
//
//    ){
//
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(10.dp),
//        onClick = { onCardClick() }, // Ensure it's callable
//        colors = CardDefaults.cardColors(containerColor = Color.Blue)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) { // Add padding for better spacing
//            Text(text = todo.title)
//            Spacer(modifier = Modifier.height(22.dp))
//            Text(text = if (todo.completed) "Completed" else "Not Completed") // Ensure correct text formatting
//        }
//    }}
//
//@Preview
//@Composable
//fun TodoItemCardPrview(){
//    TodoTheme {
//        TodoItem(
//            title = "",
//            userId = 1,
//            id=2,
//            completed = true,
//        )
//        onCardClick={}
//    }
//}