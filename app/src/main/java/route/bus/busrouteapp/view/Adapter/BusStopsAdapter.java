package route.bus.busrouteapp.view.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import route.bus.busrouteapp.Model.StopsItem;
import route.bus.busrouteapp.R;


public class BusStopsAdapter extends RecyclerView.Adapter<BusStopsAdapter.MyViewHolder> {
 
    private List<StopsItem> stopsList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewStop;
        private ImageView imageViewLine;
 
        public MyViewHolder(View view) {
            super(view);
            textViewStop = (TextView) view.findViewById(R.id.txt_stop);
            imageViewLine = (ImageView) view.findViewById(R.id.img_line);
          
        }
    }
 
 
    public BusStopsAdapter( List<StopsItem> stopsList) {
        this.stopsList = stopsList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_stops_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StopsItem  StopsItem = stopsList.get(position);
        holder.textViewStop.setText( StopsItem.getName());
        holder.itemView.setTag(position);

        if(position==(stopsList.size()-1))
        {
            holder.imageViewLine.setVisibility(View.GONE);
        }

    }
 
    @Override
    public int getItemCount() {
        return stopsList.size();
    }}