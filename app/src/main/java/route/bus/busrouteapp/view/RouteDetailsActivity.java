package route.bus.busrouteapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import route.bus.busrouteapp.Model.RoutesItem;
import route.bus.busrouteapp.R;
import route.bus.busrouteapp.view.Adapter.BusStopsAdapter;

/**
 * Created by NOBLE on 07-01-2018.
 */

public class RouteDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BusStopsAdapter mAdapter;
    private Context context;
    private TextView textViewDetails;
    private TextView textViewName;
    private ImageView imageViewBus;
    private ImageView imageViewAccessibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewDetails = (TextView) findViewById(R.id.textViewDetails);
        imageViewBus = (ImageView) findViewById(R.id.imageViewBus);
        imageViewAccessibility = (ImageView) findViewById(R.id.imageViewAccessibility);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewStops);


        Intent i = getIntent();
        RoutesItem dene = (RoutesItem) i.getSerializableExtra("values");
        textViewName.setText(dene.getName());
        textViewDetails.setText(dene.getDescription());
        Picasso.with(this).load(dene.getImage()).error(R.mipmap.ic_launcher).into(imageViewBus);

        if (dene.getAccessible()) {
            imageViewAccessibility.setVisibility(View.VISIBLE);
        }


        mAdapter = new BusStopsAdapter(dene.getStops());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}

