package com.seongenie.example.infra.login

import com.google.gson.annotations.SerializedName

data class NaverLoginResult(
        @SerializedName("resultcode") val resultCode: String,
        @SerializedName("message") val message: String,
        @SerializedName("response") val response: data
) {
  data class data(
          @SerializedName("email") val email: String,
          @SerializedName("nickname") val nickname: String,
          @SerializedName("profile_image") val profileImage: String,
          @SerializedName("age") val age: String,
          @SerializedName("gender") val gender: String,
          @SerializedName("id") val id: String,
          @SerializedName("name") var name: String,
          @SerializedName("birthday") var birthday: String
  )
}


//{
//  "resultcode": "00",
//  "message": "success",
//  "response": {
//  "email": "openapi@naver.com",
//  "nickname": "OpenAPI",
//  "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//  "age": "40-49",
//  "gender": "F",
//  "id": "32742776",
//  "name": "오픈 API",
//  "birthday": "10-01"
//}
//}