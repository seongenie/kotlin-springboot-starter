package com.seongenie.example.service

import com.seongenie.example.controller.user.UserResponse
import com.seongenie.example.controller.user.UserView
import com.seongenie.example.domain.User
import com.seongenie.example.domain.UserRepository
import com.seongenie.example.domain.infra.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService : BaseService() {

    @Autowired
    lateinit var repository : UserRepository

    fun createUser(userView : UserView) {
        var user = User(userView.userId, userView.username)
        repository.add(user)
    }

    fun getUserList(username : String) : UserResponse {
        var result = UserResponse(UserView())
        var userList : List<User> = repository.findUsersByUsername(username)
        return result
    }

    fun getUser(userId : String) : UserResponse {
        var user = repository.findUserByUserId(userId)
        return UserView(user)
    }
}