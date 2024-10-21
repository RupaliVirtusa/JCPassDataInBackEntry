package com.assignment.jcpassdatainbackentry.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.jcpassdatainbackentry.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _userState = MutableStateFlow<List<User>>(emptyList())

    val userState: StateFlow<List<User>> = _userState.asStateFlow()

    init {
        val list = arrayListOf<User>()
        list.add(User(1, "Martin", "Pune"))
        list.add(User(2, "David", "Mumbai"))
        list.add(User(3, "Lisa", "Bengaluru"))
        list.add(User(4, "Steve", "Chennai"))
        _userState.value = list
    }

}