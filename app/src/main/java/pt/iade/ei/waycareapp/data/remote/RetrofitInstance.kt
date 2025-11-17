package pt.iade.ei.waycareapp.data.remote

import ExifApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: ExifApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")   // Emulador Android
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExifApi::class.java)
    }
}


