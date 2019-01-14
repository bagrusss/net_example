package ru.bagrusss.myapplication.net;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by bagrusss on 14.01.2019
 */
public interface HelloApi {

    @GET("/api/v1/hello")
    Single<HelloMessage> getHelloMessage();

}
