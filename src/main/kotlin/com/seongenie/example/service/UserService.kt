package com.seongenie.example.service

import com.seongenie.example.controller.user.UserView
import com.seongenie.example.domain.user.User
import com.seongenie.example.domain.user.UserRepository
import com.seongenie.example.domain.infra.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService : BaseService() {

  @Autowired
  lateinit var repository: UserRepository

  fun createUser(userView: UserView) {
    var user = User(userView.userId, userView.username)
    repository.add(user)
  }

  fun getUsers(username: String): List<UserView> {
    val userList: List<User> = repository.findUsersByUsername(username)
    val userListView = userList.map { user -> UserView(user) }
    return userListView
  }

  fun getAllUsers(): List<UserView> {
    val users = repository.findAll()
    val userViews = users.map { user -> UserView(user) }
    return userViews
  }

  fun getUser(userId: String): UserView {
    var user = repository.findUserByUserId(userId)
    return UserView(user)
  }

  fun getUser(id: Long): UserView? {
    var user = repository.findById(id)
    if (user == null) return null
    return UserView(user)
  }

}