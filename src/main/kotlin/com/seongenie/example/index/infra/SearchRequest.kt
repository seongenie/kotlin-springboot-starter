package com.seongenie.example.index.infra

data class SearchRequest (
        var should: List<Map<String, String>> = listOf<HashMap<String, String>>(),
        var must: List<Map<String, String>> = listOf<HashMap<String, String>>()
)