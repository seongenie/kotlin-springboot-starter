package com.seongenie.example.index.infra

interface Crawler<T> {
  open fun crawl(text: String, total: Int = 1, success: ((T) -> Unit))
}
