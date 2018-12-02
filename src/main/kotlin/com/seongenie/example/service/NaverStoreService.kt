package com.seongenie.example.service

import com.seongenie.example.domain.infra.BaseService
import com.seongenie.example.domain.naver.NaverStore
import com.seongenie.example.domain.naver.NaverStoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NaverStoreService: BaseService() {

  @Autowired
  lateinit var repository: NaverStoreRepository


  fun insertNaverStore(naverStore: NaverStore) {
    repository.add(naverStore)
  }

  fun getNaverStores(): List<NaverStore> {
    return repository.findAll()
  }
}