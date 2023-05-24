package com.ssafy.green_plate.api

import com.ssafy.green_plate.dto.User
import com.ssafy.green_plate.dto.UserInfoResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    // 사용자 정보를 추가한다.
    @POST("rest/user")
    suspend fun insert(@Body body: User): Boolean

    // 사용자의 정보와 함께 사용자의 주문 내역, 사용자 등급 정보를 반환한다.
    // userInfo["grade"]는 LinkedTreeMap<String,String>으로 들어오므로 Gson 의 Type을 이용하여
    // Object 로 바꾸어 준다.
    // val gradeInfo = Gson().fromJson<Grade>(userInfo["grade"].toString(), object: TypeToken<Grade>(){}.type)
//    @POST("rest/user/info")
//    suspend fun getInfo(@Query("id") id: String): HashMap<String, Any>
    @POST("rest/user/info")
    suspend fun getInfo(@Query("id") id: String): UserInfoResponse

    // request parameter로 전달된 id가 이미 사용중인지 반환한다.
    @GET("rest/user/isUsed")
    suspend fun isUsedId(@Query("id") id: String): Boolean

    // 로그인 처리 후 성공적으로 로그인 되었다면 loginId라는 쿠키를 내려준다.
    @POST("rest/user/login")
    suspend fun login(@Body body: User?): User?

    @DELETE("/delete/{id}")
    suspend fun delete(@Path("id") id : Int) : Int
}