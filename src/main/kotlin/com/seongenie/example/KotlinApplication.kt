package com.seongenie.example

import com.seongenie.example.collector.naver.NaverStoreCrawler
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("com.seongenie.example")
@EnableJpaRepositories(basePackages = ["com.seongenie.example.domain"])
@EntityScan(basePackages = ["com.seongenie.example.domain"])
class KotlinApplication
fun main(args: Array<String>) {
    SpringApplication.run(KotlinApplication::class.java, *args)
}
