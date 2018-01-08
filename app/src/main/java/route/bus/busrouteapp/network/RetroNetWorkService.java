package route.bus.busrouteapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import route.bus.busrouteapp.Model.Response;

/**
 * Created by NOBLE on 07-01-2018.
 */

public interface RetroNetWorkService {

    @GET("5808f00d10000005074c6340")
    Call<Response> getBusRoutes();
}
