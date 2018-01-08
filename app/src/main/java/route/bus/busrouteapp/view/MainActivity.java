package route.bus.busrouteapp.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.List;

import route.bus.busrouteapp.Contract.BusRoutContract;
import route.bus.busrouteapp.Model.RoutesItem;
import route.bus.busrouteapp.Presenter.BusRoutPresenter;
import route.bus.busrouteapp.R;
import route.bus.busrouteapp.view.Adapter.BusRoutsAdapter;

public class MainActivity extends AppCompatActivity implements BusRoutContract.View {

    private BusRoutContract.Presenter presenter;
    private RecyclerView recyclerView;
    private BusRoutsAdapter mAdapter;
    private Context context;
    private TextView toobarTextview;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        presenter = new BusRoutPresenter(this);
        presenter.fetchRouteData();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        toobarTextview = (TextView) toolbar.findViewById(R.id.title);
        toobarTextview.setText(getString(R.string.routes_header));
    }


    @Override
    public void showDialog() {
        progress = new ProgressDialog(this);
        progress.setMessage("Downloading");
        progress.setIndeterminate(true);
        progress.show();
    }

    @Override
    public void showError(Exception e) {
        Snackbar snackbar = Snackbar
                .make(recyclerView, e.getMessage(), Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    @Override
    public void showRouts(List<RoutesItem> list) {

        mAdapter = new BusRoutsAdapter(context, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void dismissDialog() {
        progress.dismiss();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();

    }
}
