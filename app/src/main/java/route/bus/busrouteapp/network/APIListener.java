package route.bus.busrouteapp.network;

/**
 * Created by NOBLE on 07-01-2018.
 */

public interface APIListener<T> {
    void onSuccess(T response);
    void onError(APIException exception);
}
