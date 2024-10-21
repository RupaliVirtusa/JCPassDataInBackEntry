package com.assignment.jcpassdatainbackentry

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.assignment.jcpassdatainbackentry.view.UserAddress
import com.assignment.jcpassdatainbackentry.view.UserDetails
import com.assignment.jcpassdatainbackentry.view.UserList
import com.assignment.jcpassdatainbackentry.view.UserListScreen
import com.assignment.jcpassdatainbackentry.view.UserViewModel

enum class UserScreen {
    UserList,
    UserDetails,
    UserDetailsId
}

@Composable
fun UserApp(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = UserScreen.UserList.name,
        modifier = Modifier.fillMaxWidth()
    ) {
        composable(UserScreen.UserList.name) {
            UserListScreen { userId ->
                navController.navigate("${UserScreen.UserDetails.name}/${userId.id}/${userId.name}/${userId.address}")
            }
        }
        composable(
            "${UserScreen.UserDetails.name}/{userId}/{name}/{address}",
            arguments = listOf(navArgument("userId") {
                type = NavType.StringType
            }, navArgument("name") {
                type = NavType.StringType
            }, navArgument("address") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            val name = backStackEntry.arguments?.getString("name")
            val address = backStackEntry.arguments?.getString("address")

            if (userId != null) {
                if (name != null) {
                    if (address != null) {
                        UserDetails(navController, userId, name, address) {
                            navController.navigate("${UserScreen.UserDetailsId.name}/${address}")
                        }
                    }
                }
            }
        }
        composable(
            "${UserScreen.UserDetailsId.name}/{address}",
            arguments = listOf(navArgument("address") {
                type = NavType.StringType
            })
        ) { backStackentry ->
            val address = backStackentry.arguments?.getString("address")
            if (address != null) {
                UserAddress(id = address)
            }
        }
    }
}