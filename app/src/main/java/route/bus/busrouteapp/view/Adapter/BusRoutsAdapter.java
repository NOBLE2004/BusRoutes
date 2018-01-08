package route.bus.busrouteapp.view.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import route.bus.busrouteapp.Model.RoutesItem;
import route.bus.busrouteapp.R;
import route.bus.busrouteapp.view.RouteDetailsActivity;

public class BusRoutsAdapter extends RecyclerView.Adapter<BusRoutsAdapter.MyViewHolder> {
 
    private List<RoutesItem> routsList;
    private Context context;
    private RoutesItem routesItem;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView busName;
        private ImageView busImage;
 
        public MyViewHolder(View view) {
            super(view);
            busName = (TextView) view.findViewById(R.id.textViewName);
            busImage = (ImageView) view.findViewById(R.id.imageViewBus);
        }
    }
 
 
    public BusRoutsAdapter(Context context,List<RoutesItem> routsList) {
        this.context=context;
        this.routsList = routsList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_routes_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        routesItem = routsList.get(position);
        holder.busName.setText(routesItem.getName());
        Picasso.with(context).load(routesItem.getImage()).error(R.mipmap.ic_launcher).into(holder.busImage);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) v.getTag();

                Intent intent = new Intent(context,  RouteDetailsActivity.class);
                intent.putExtra("values", routsList.get(position));
                context.startActivity(intent);}
        });

    }
 
    @Override
    public int getItemCount() {
        return routsList.size();
    }}