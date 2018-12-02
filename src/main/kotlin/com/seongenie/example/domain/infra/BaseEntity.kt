package com.seongenie.example.domain.infra

import com.google.gson.annotations.SerializedName
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue
    @SerializedName("id")
    var id : Long? = null

    @field:CreationTimestamp
    lateinit var createDate: Date

    @field:UpdateTimestamp
    lateinit var updateDate : Date
}