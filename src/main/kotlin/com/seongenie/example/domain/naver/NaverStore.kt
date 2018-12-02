package com.seongenie.example.domain.naver

import com.google.gson.annotations.SerializedName
import com.seongenie.example.domain.infra.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Table(uniqueConstraints = [(UniqueConstraint(columnNames = ["id"]))])
@Entity
data class NaverStore (
        @SerializedName("title") var title: String? = null,
        @SerializedName("link") var link: String? = null,
        @SerializedName("category") var category: String? = null,
        @SerializedName("description") var description: String? = null,
        @SerializedName("telephone") var telephone: String? = null,
        @SerializedName("address") var address: String? = null,
        @SerializedName("roadAddress") var roadAddress: String? = null,
        @SerializedName("mapx") var mapx: String? = null,
        @SerializedName("mapy") var mapy: String? = null
): BaseEntity()