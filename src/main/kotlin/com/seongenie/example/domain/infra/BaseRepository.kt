package com.seongenie.example.domain.infra

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


/**
 * BaseRepository
 */
abstract class BaseRepository<T> {
  @PersistenceContext
  protected open lateinit var entityManager: EntityManager

  var type: Class<T> = getGenericClassType() as Class<T>
  val builder get() = entityManager.criteriaBuilder

  open fun add(entity: Any?) {
    entityManager.persist(entity)
  }

  open fun update(entity: Any?) {
    entityManager.merge(entity)
  }

  open fun remove(entity: Any?) {
    entityManager.remove(entity);
  }

  open fun findById(id: Long) : T? {
    var query : CriteriaQuery<T> = builder.createQuery(type)
    var root : Root<T> = query.from(type)
    var predicate : Predicate = builder.equal(root.get<String>("id"), id)
    query.select(root).where(predicate)
    var q : TypedQuery<T> = entityManager.createQuery(query)
    var resultList = q.resultList
    if(resultList.isEmpty()) return null
    return resultList[0]
  }

  open fun findAll(): List<T> {
    val builder = entityManager.criteriaBuilder
    var query = builder.createQuery(type)
    var root = query.from(type)
    query.select(root)
    var q = entityManager.createQuery(query)
    return q.resultList
  }


  private fun getGenericClassType(): Type {
    var type = javaClass.genericSuperclass
    while (type !is ParameterizedType) {
      if (type is ParameterizedType) {
        type = ((type as ParameterizedType).getRawType() as Class<*>).genericSuperclass
      } else {
        type = (type as Class<*>).genericSuperclass
      }
    }

    return (type as ParameterizedType).getActualTypeArguments()[0]
  }
}
