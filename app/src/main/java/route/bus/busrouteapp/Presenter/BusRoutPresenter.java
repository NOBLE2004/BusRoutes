package route.bus.busrouteapp.Presenter;

import android.util.Log;

import route.bus.busrouteapp.Contract.BusRoutContract;
import route.bus.busrouteapp.Contract.BusRoutInteractor;
import route.bus.busrouteapp.Model.Response;
import route.bus.busrouteapp.network.APIException;
import route.bus.busrouteapp.network.APIListener;


/**
 * Created by NOBLE on 07-01-2018.
 */

public class BusRoutPresenter implements BusRoutContract.Presenter {
    public static final String TAG = BusRoutPresenter.class.getSimpleName();
    private final BusRoutContract.View view;
    private final BusRoutContract.Interactor routInteractor;

    public BusRoutPresenter(BusRoutContract.View view) {
        this.view = view;
        routInteractor = new BusRoutInteractor();
    }
    @Override
    public void fetchRouteData() {
        view.showDialog();
        routInteractor.fetchRouteData(new APIListener<Response>() {
            @Override
            public void onSuccess(Response response) {
                Log.d(TAG,"Response:" + response);
                handleSuccessResponse(response);
            }

            @Override
            public void onError(APIException exception) {
                Log.d(TAG,"API - Error Response:" + exception.getErrorMessage());
                handleError(exception);
            }
        });
    }

    private void handleError(APIException exception) {
        view.dismissDialog();
        view.showError(exception);
    }

    private void handleSuccessResponse(Response response) {
        view.dismissDialog();
        view.showRouts(response.getRoutes());
    }

    @Override
    public void onDestroy() {
        routInteractor.cancelRequest();
    }
}
