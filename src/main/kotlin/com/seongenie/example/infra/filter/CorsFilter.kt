package com.seongenie.example.infra.filter

import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.http.HttpServletResponse

@Component
class CorsFilter: Filter {
  override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
    var httpServletResponse = response as HttpServletResponse

    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-NAVER-TOKEN, x-auth-token");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials");

    chain?.doFilter(request, httpServletResponse);
  }

  override fun init(filterConfig: FilterConfig?) {
  }

  override fun destroy() {
  }

}