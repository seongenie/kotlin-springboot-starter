package com.seongenie.example.domain.user

import com.seongenie.example.domain.infra.BaseRepository
import org.springframework.stereotype.Repository
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Repository
class UserRepository : BaseRepository<User>() {

  /**
   * find user by userId
   */
  fun findUserByUserId(userId: String): User {
    var query: CriteriaQuery<User> = builder.createQuery(User::class.java)
    var root: Root<User> = query.from(User::class.java)
    var predicate: Predicate = builder.equal(root.get<String>("userId"), userId)
    query.select(root).where(predicate)
    var q: TypedQuery<User> = entityManager.createQuery(query)
    return q.singleResult
  }

  /**
   * find users by username
   */
  fun findUsersByUsername(username: String): List<User> {
    var query: CriteriaQuery<User> = builder.createQuery(User::class.java)
    var root: Root<User> = query.from(User::class.java)
    var predicate: Predicate = builder.like(root.get<String>("username"), username)
    query.select(root).where(predicate)
    var q: TypedQuery<User> = entityManager.createQuery(query)
    return q.resultList
  }
}