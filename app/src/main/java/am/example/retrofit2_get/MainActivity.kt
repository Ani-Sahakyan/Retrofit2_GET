package am.example.retrofit2_get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list : MutableList<UsersModel.UserData>? = ArrayList()

        GlobalScope.launch (Dispatchers.IO){
            val call = UsersRetrofitService.retrofit.create(UsersAPI::class.java).getUserList(2)
            val userData = call.execute().body()?.data

            withContext(Dispatchers.Main){
                val dataSize = if (userData?.size != null) userData?.size else 0
                for (i in 0..dataSize-1)
                    list?.add(
                        UsersModel.UserData(
                            userData?.get(i)?.id,
                            userData?.get(i)?.email,
                            userData?.get(i)?.first_name,
                            userData?.get(i)?.last_name,
                            userData?.get(i)?.avatar
                        )
                    )

                Log.d("dataList"," ${list}")
                val recyclerView = findViewById<RecyclerView>(R.id.recycelerView)
                val adapter = RecyclerAdapter(list)
                recyclerView.setAdapter(adapter)
                recyclerView.setLayoutManager(LinearLayoutManager(parent));
            }
        }


       /* GlobalScope.launch(Dispatchers.IO) {
            val call = UsersRetrofitService.retrofit.create(UsersAPI::class.java).getUsersList(2)
            //val data = call.execute().body()?.users
            val data = call.execute().body()?.users?.get(0)?.first_name

            withContext(Dispatchers.Main){
                Log.d("data = ","$data")
//                    textView.setText(data)
           *//*     val dataSize = if (data?.size != null) data?.size else 0

                Log.d("dataSize = ","$dataSize")
                for (i in 0..dataSize)
                     list?.add(
                         UsersModel.UsersList(
                             data?.get(i)?.id,
                             data?.get(i)?.email,
                             data?.get(i)?.first_name,
                             data?.get(i)?.last_name,
                             data?.get(i)?.avatar
                         )
                     )*//*
                val recyclerView = findViewById<RecyclerView>(R.id.recycelerView)
               // Log.d("list = ","${list?.get(0)?.last_name} ")
                list?.add(UsersModel.UsersList(3,"a","b","c","d"))
                list?.add(UsersModel.UsersList(3,"e","f","g","h"))
                Log.d("list2 = ","list = ${list?.get(0)?.first_name}")
                val adapter = RecyclerAdapter(list)
                recyclerView.setAdapter(adapter)
                recyclerView.setLayoutManager(LinearLayoutManager(parent));

            }
        }*/
    }
}