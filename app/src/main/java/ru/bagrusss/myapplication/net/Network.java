package ru.bagrusss.myapplication.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by bagrusss on 14.01.2019
 */
public class Network {

    public static final OkHttpClient client = new OkHttpClient.Builder()
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    public static final Gson gson = new GsonBuilder().setLenient()
            .create();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl("http://10.23.44.202:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build();

    public static final HelloApi helloApi = retrofit.create(HelloApi.class);

}
