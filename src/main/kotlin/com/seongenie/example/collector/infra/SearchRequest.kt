package com.seongenie.example.collector.infra

data class SearchRequest (
        var should: List<Map<String, String>> = listOf<HashMap<String, String>>(),
        var must: List<Map<String, String>> = listOf<HashMap<String, String>>()
)