package am.example.retrofit2_get

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersAPI {

    @GET("api/users")
    fun getUserList(@Query("page") page: Int) : Call<UsersModel>
}

object UsersRetrofitService{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}