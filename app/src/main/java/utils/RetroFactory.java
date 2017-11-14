package utils;

import java.util.concurrent.TimeUnit;

import atts.API;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fan on 2017/11/8.
 */

public class RetroFactory {



//    private static OkHttpClient httpClient = new OkHttpClient.Builder()
//            .addInterceptor(new LoggingInterceptor()).connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .build();
    private static ApiServer retrofitService = new Retrofit.Builder()
            .baseUrl(API.SHOUYE)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            .client(httpClient)
            .build()
            .create(ApiServer.class);
    private static ApiServer retrofitServicepost = new Retrofit.Builder()
            .baseUrl(API.DENGLU)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            .client(httpClient)
            .build()
            .create(ApiServer.class);
    private static ApiServer retrofitService_classify = new Retrofit.Builder()
            .baseUrl(API.CLASSIFY)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            .client(httpClient)
            .build()
            .create(ApiServer.class);

    //单列模式
    public static ApiServer getInstance() {
        return retrofitService;
    }
    public static ApiServer getInstancepost() {
        return retrofitServicepost;
    }
    public static ApiServer getInstance_classify() {
        return retrofitService_classify;
    }

}
