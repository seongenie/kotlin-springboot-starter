package com.seongenie.example.infra.filter

import javax.servlet.*
import javax.servlet.http.HttpServletRequest

class AuthenticationFilter: Filter {
  override fun destroy() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

    val httpServletRequest = request as HttpServletRequest
    val token = httpServletRequest.getHeader("x-naver-token")
    if (token.isEmpty()) {
      TODO("redirect to login page code")
    }

    chain?.doFilter(request, response)
  }

  override fun init(filterConfig: FilterConfig?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}