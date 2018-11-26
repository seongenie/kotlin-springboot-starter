package com.seongenie.example.controller.baseCoin

import com.seongenie.example.collector.exchange.cryptopia.Upbit
import com.seongenie.example.domain.BaseCoin
import com.seongenie.example.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController {

  @Autowired
  lateinit var userService: UserService

  @RequestMapping(value = ["/users/{username}"], method = [RequestMethod.GET])
  fun getUserList(username: String): UserView {
    return userService.getUserList(username)
  }

  @RequestMapping(value = ["/user/{userId}"], method = [RequestMethod.GET])
  fun getUser(@PathVariable("userId") userId: String): List<String> {
    return userService.getUser(userId)
  }

  @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
  fun getUser(userView: UserView) {
    userService.createUser(userView)
  }
}