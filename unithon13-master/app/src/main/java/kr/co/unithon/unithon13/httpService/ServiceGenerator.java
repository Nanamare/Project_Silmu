package kr.co.unithon.unithon13.httpService;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by daehyun on 16. 2. 13..
 */
public class ServiceGenerator {
    public static final String API_BASE_URL = "http://openAPI.seoul.go.kr:8088/";
    public static final String API_PATH_URL = "http://swopenapi.seoul.go.kr/api/subway/";
    public static final String API_AUTH_KEY = "5356576b65646870333470684a4661";

    //    http://swopenapi.seoul.go.kr/api/subway/5356576b65646870333470684a4661/xml/shortestRoute/0/5/소요산/잠실나루
    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL+ API_AUTH_KEY)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setConverter( new SimpleXMLConverter())
            .setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
        builder =  new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL + API_AUTH_KEY)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new SimpleXMLConverter())
                .setClient(new OkClient(new OkHttpClient()));
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
    public static  <S> S createPathService(Class<S> serviceClass) {
        builder = new RestAdapter.Builder()
                .setEndpoint(API_PATH_URL+ API_AUTH_KEY)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter( new SimpleXMLConverter())
                .setClient(new OkClient(new OkHttpClient()));
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

}
