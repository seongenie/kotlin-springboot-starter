package com.seongenie.example.index.infra

import com.google.gson.Gson
import com.seongenie.example.infra.ElasticsearchConfig
import org.apache.http.HttpHost
import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentType
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Elasticsearch Request Helper
 */
@Component
class ESRequestHelper {

  @Autowired
  lateinit var config: ElasticsearchConfig

  /**
   * Create new client for request
   */
  fun createClient(): RestHighLevelClient {
    return RestHighLevelClient(
            RestClient.builder(
                    HttpHost(config.server!!["host"], Integer.parseInt(config.server!!["port"]), config.server!!["scheme"])))
  }

  /**
   * Return indexRequest
   */
  fun indexRequest(any: Any): IndexRequest {
    val jsonString = Gson().toJson(any)
    return IndexRequest(config.index).source(jsonString, XContentType.JSON)
  }

  /**
   * Return SearchRequest
   */
  fun searchRequest(query: QueryBuilder, size: Int = 10): SearchRequest {
    val searchSourceBuilder = SearchSourceBuilder().query(query).size(size);
    return SearchRequest().source(searchSourceBuilder)
  }

  /**
   * Return BulkRequest object which request numbers of index at once
   */
  fun bulkIndexRequest(list: List<Any>): BulkRequest {
    val bulkRequest = BulkRequest()
    list.forEach { bulkRequest.add(indexRequest(it)) }
    return bulkRequest
  }
}
