package com.seongenie.example.domain

import com.seongenie.example.domain.infra.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint


@Table( uniqueConstraints = [UniqueConstraint(columnNames = ["id", "userId"])])
@Entity
data class User(var userId : String, var username : String) : BaseEntity();

