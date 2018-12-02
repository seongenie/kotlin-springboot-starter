package com.seongenie.example.controller.user

import com.seongenie.example.domain.user.User
import org.springframework.beans.BeanUtils
import java.io.Serializable

class UserView : Serializable {
  lateinit var userId: String
  lateinit var username: String

  constructor()

  constructor(user: User) {
    BeanUtils.copyProperties(user, this)
  }

  constructor(userId: String, username: String) {
    this.userId = userId
    this.username = username
  }
}