package com.seongenie.example.collector.infra

import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.springframework.stereotype.Component

@Component
class ESQueryHelper {

  /**
   * create simple match query from request
   */
  fun simpleMatchQuery(request: SearchRequest): QueryBuilder {
    return QueryBuilders.boolQuery().apply {
      request.should.forEach { it.forEach { key, value -> should(QueryBuilders.matchQuery(key, value)) } }
      request.must.forEach { it.forEach { key, value -> must(QueryBuilders.matchQuery(key, value)) } }
    }
  }
}