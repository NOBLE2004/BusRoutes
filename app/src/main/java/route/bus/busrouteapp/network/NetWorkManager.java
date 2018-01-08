package route.bus.busrouteapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NOBLE on 07-01-2018.
 */

public class NetWorkManager {

    private static NetWorkManager intance;
    private static final String  BASE_URL = "http://www.mocky.io/v2/";
    private Retrofit retrofit;
    public static NetWorkManager getInstance() {
        if(null == intance) {
            intance = new NetWorkManager();
        }
        return intance;
    }
    private NetWorkManager() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public RetroNetWorkService getService() {
        return retrofit.create(RetroNetWorkService.class);
    }

}
