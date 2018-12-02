package com.seongenie.example.collector.infra

interface Crawler<T> {
  open fun crawl(text: String, success: ((T) -> Unit))
}
