package com.seongenie.example.domain.infra

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaBuilder

/**
 * BaseRepository
 */
abstract class BaseRepository {
  @PersistenceContext
  protected open lateinit var entityManager: EntityManager

  val builder: CriteriaBuilder get() = entityManager.criteriaBuilder

  open fun add(entity: Any?) {
    entityManager.persist(entity)
  }

  open fun update(entity: Any?) {
    entityManager.merge(entity)
  }

  open fun remove(entity: Any?) {
    entityManager.remove(entity);
  }
}