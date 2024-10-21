package com.assignment.jcpassdatainbackentry.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
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
        append(id)
        append(name)
        append(address)
    }, modifier = Modifier
        .fillMaxWidth()
        .clickable {
            OnTextClick()
            //TODO  or u can move like below too
            // navController.navigate(UserScreen.UserDetailsId.name)
        })
}