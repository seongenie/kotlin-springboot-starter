package com.seongenie.example.controller.user

import com.seongenie.example.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class UserController {

  @Autowired
  lateinit var userService: UserService


  /**
   * return users filtered by username
   */
  @RequestMapping(value = "/users", method = [RequestMethod.GET])
  fun getUsers(@RequestParam("username") username: String): List<UserView> {
    return userService.getUsers(username)
  }

  /**
   * return all users
   */
  @RequestMapping(value = "/users/all", method = [RequestMethod.GET])
  fun getAllUsers(): List<UserView> {
    return userService.getAllUsers()
  }

  /**
   * return one user specified by userId
   */
  @RequestMapping(value = "/user", method = [RequestMethod.GET])
  fun getUser(@RequestBody userView: UserView): UserView {
    return userService.getUser(userView.userId)
  }

  /**
   * return one user specified by entity id
   */
  @RequestMapping(value = "/user/{id}", method = [RequestMethod.GET])
  fun getUser(@PathVariable("id") id: Long): UserView? {
    return userService.getUser(id)
  }

  /**
   *
   */
  @RequestMapping(value = "/user", method = [RequestMethod.POST])
  fun createUser(@RequestBody userView: UserView) {
    userService.createUser(userView)
  }
}