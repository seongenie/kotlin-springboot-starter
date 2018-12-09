package com.seongenie.example.index.infra

interface Crawler<T> {
  open fun crawl(text: String, success: ((T) -> Unit))
}
