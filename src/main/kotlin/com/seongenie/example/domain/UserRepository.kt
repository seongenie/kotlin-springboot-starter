package com.seongenie.example.domain

import com.seongenie.example.domain.infra.BaseRepository
import org.springframework.stereotype.Repository
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


@Repository
class UserRepository : BaseRepository() {

    /**
     * userId로 user 검색 (equal)
     */
    fun findUserByUserId(userId: String) : User {
        var query : CriteriaQuery<User> = builder.createQuery(User::class.java)
        var root : Root<User> = query.from(User::class.java)
        var predicate : Predicate = builder.equal(root.get<String>("user_id"), userId)
        query.select(root).where(predicate)
        var q : TypedQuery<User> = entityManager.createQuery(query)
        return q.singleResult
    }

    /**
     * username 으로 user 목록 검색 (like)
     */
    fun findUsersByUsername(username: String) : List<User> {
        var query : CriteriaQuery<User> = builder.createQuery(User::class.java)
        var root : Root<User> = query.from(User::class.java)
        var predicate : Predicate = builder.like(root.get<String>("username"), username)
        query.select(root).where(predicate)
        var q : TypedQuery<User> = entityManager.createQuery(query)
        return q.resultList
    }
}