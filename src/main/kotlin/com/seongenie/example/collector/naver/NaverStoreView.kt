package com.seongenie.example.collector.naver

data class NaverStoreView(
        var title: String? = null,
        var link: String? = null,
        var category: String? = null,
        var description: String? = null,
        var telephone: String? = null,
        var address: String? = null,
        var roadAddress: String? = null,
        var mapx: Long? = null,
        var mapy: Long? = null
)

//<title>조선옥</title>
//<link />
//<category>한식&gt;육류,고기요리</category>
//<description>연탄불 한우갈비 전문점.</description>
//<telephone>02-2266-0333</telephone>
//<address>서울특별시 중구 을지로3가 229-1 </address>
//<roadAddress>서울특별시 중구 을지로15길 6-5 </roadAddress>
//<mapx>311277</mapx>
//<mapy>552097</mapy>