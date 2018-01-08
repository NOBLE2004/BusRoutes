package route.bus.busrouteapp.Contract;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import route.bus.busrouteapp.Model.Response;
import route.bus.busrouteapp.network.APIException;
import route.bus.busrouteapp.network.APIListener;
import route.bus.busrouteapp.network.NetWorkManager;

/**
 * Created by NOBLE on 07-01-2018.
 */

public class BusRoutInteractor implements BusRoutContract.Interactor {
    public static final String TAG = BusRoutInteractor.class.getSimpleName();
    Call<Response> routeCall;
    @Override
    public void cancelRequest() {
        if(null != routeCall) {
            routeCall.cancel();
        }
    }

    @Override
    public void fetchRouteData(final APIListener<Response> listener) {
     Call<Response> routeCall =    NetWorkManager.getInstance().getService().getBusRoutes();
     routeCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()) {
                    handleOnResponse(response,listener);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                handleError(call,t,listener);
            }
        });
    }

    private void handleOnResponse(retrofit2.Response<Response> response, APIListener<Response> listener) {
      if(null != listener) {
          listener.onSuccess(response.body());
      }
    }

    private void handleError(Call<Response> call, Throwable t, APIListener<Response> listener) {
        APIException apiException = new APIException(t.getLocalizedMessage(),t);
        Log.d(TAG,"API-Error:" + t.getLocalizedMessage() +"," + t.getMessage());
        if(null != listener) {
            listener.onError(apiException);
        }
    }
}
