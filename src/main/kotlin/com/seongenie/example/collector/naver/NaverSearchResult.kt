package com.seongenie.example.collector.naver

data class NaverSearchResult(
        var title: String? = null,
        var link: String? = null,
        var description: String? = null,
        var lastBuildDate: String? = null,
        var total: String? = null,
        var start: String? = null,
        var display: String? = null,
        var item: List<NaverStoreView>? = null
)


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