package com.seongenie.example.infra

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "elasticsearch")
data class ElasticsearchConfig(
        var server: Map<String, String>? = null,
       var index: String ?= null
)