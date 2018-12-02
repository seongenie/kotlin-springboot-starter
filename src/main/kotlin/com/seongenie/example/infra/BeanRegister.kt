package com.seongenie.example.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@Configuration
class BeanRegister {

  @Bean
  fun jacksonMessageConverter(): MappingJackson2HttpMessageConverter {
    return MappingJackson2HttpMessageConverter()
  }
}