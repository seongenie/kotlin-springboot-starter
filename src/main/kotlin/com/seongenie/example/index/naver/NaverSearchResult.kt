package com.seongenie.example.index.naver

import com.google.gson.annotations.SerializedName
import com.seongenie.example.domain.naver.NaverStore
import java.io.Serializable

data class NaverSearchResult (
        @SerializedName("title") var title: String? = null,
        @SerializedName("link") var link: String? = null,
        @SerializedName("description") var description: String? = null,
        @SerializedName("lastBuildDate") var lastBuildDate: String? = null,
        @SerializedName("total") var total: Int,
        @SerializedName("start") var start: Int,
        @SerializedName("display") var display: Int? = null,
        @SerializedName("items") var items: List<NaverStore>? = null
): Serializable


//<title>Naver Open API - local ::'갈비집'</title>
//<link>http://search.naver.com</link>
//<description>Naver Search Result</description>
//<lastBuildDate>Tue, 04 Oct 2016 13:10:58 +0900</lastBuildDate>
//<total>407</total>
//<start>1</start>
//<display>10</display>
//<item>
//  <title>조선옥</title>
//  <link />
//  <category>한식&gt;육류,고기요리</category>
//  <description>연탄불 한우갈비 전문점.</description>
//  <telephone>02-2266-0333</telephone>
//  <address>서울특별시 중구 을지로3가 229-1 </address>
//  <roadAddress>서울특별시 중구 을지로15길 6-5 </roadAddress>
//  <mapx>311277</mapx>
//  <mapy>552097</mapy>
//</item>