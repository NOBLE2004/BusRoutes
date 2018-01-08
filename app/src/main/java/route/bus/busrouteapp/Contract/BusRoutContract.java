package route.bus.busrouteapp.Contract;

import java.util.List;

import route.bus.busrouteapp.Model.Response;
import route.bus.busrouteapp.Model.RoutesItem;
import route.bus.busrouteapp.network.APIListener;

/**
 * Created by NOBLE on 07-01-2018.
 */

public interface BusRoutContract {

    interface View {
        void showDialog();
        void showError(Exception e);
        void showRouts(List<RoutesItem> routesItemList);
        void dismissDialog();
    }

    interface Presenter {
        void fetchRouteData();
        void onDestroy();
    }

    interface Interactor {
        void cancelRequest();
        void fetchRouteData(APIListener<Response> apiListener);
    }


}
