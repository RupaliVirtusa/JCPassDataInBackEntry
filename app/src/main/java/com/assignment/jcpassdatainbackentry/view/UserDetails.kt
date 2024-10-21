package com.assignment.jcpassdatainbackentry.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController

@Composable
fun UserDetails(
    navController: NavController,
    id: String,
    name: String,
    address: String,
    OnTextClick: () -> Unit
) {
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Blue)) {
            append("id :")
        }
        append("$id \n ")
        withStyle(style = SpanStyle(Color.Blue)) {
            append("name : ")
        }
        append("$name \n")
        withStyle(style = SpanStyle(Color.Blue)) {
            append("address : ")
        }
        append(address)

    }, modifier = Modifier
        .fillMaxWidth()
        .clickable {
            OnTextClick()
            //TODO  or u can move like below too
            // navController.navigate(UserScreen.UserDetailsId.name)
        })
}