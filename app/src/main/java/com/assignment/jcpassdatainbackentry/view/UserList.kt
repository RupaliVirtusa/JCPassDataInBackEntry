package com.assignment.jcpassdatainbackentry.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.jcpassdatainbackentry.data.User

@Composable
fun UserListScreen(OnUser: (User) -> Unit) {
    val userViewModel = UserViewModel()
    val items by userViewModel.userState.collectAsState()
    UserList(items) { user ->
        OnUser(user)
    }
}
@Composable
fun UserList(items: List<User>, OnItemClick: (User) -> Unit) {
    LazyColumn {
        items(items) { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        OnItemClick(user)
                    }
                    .height(25.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                Color.Blue,
                                fontStyle = FontStyle.Normal,
                                fontSize = 15.sp
                            )
                        ) {
                            append("Name : ")
                        }
                        append(user.name)
                    }, Modifier.weight(1f)
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(Color.Blue, fontStyle = FontStyle.Normal)) {
                            append("Address : ")
                        }
                        append(user.address)
                    }, Modifier.weight(1f)
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
        }
    }
}