package com.shubham.introretrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {
    static String API_BASE_URL = "https://api.github.com/";

    static Retrofit.Builder builder = new retrofit2.Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    static Retrofit retrofit = builder.build();

    static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}


