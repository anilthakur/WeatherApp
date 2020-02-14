package com.anil.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anil.weatherapp.R;
import com.anil.weatherapp.model.forecastweather.ListItem;
import com.anil.weatherapp.utils.Utils;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

import static com.anil.weatherapp.utils.Utils.convertDateFormat;

/**
 * Created by Anil Kumar on 2020-02-11
 */
public class ForeCastAdapter extends RecyclerView.Adapter<ForeCastAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ListItem> imageModelArrayList;

    public ForeCastAdapter(Context ctx, ArrayList<ListItem> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public ForeCastAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ForeCastAdapter.MyViewHolder holder, int position) {

        holder.temText.setText(imageModelArrayList.get(position).getMain().getTemp()+ "°C");
        holder.dayText.setText(convertDateFormat(imageModelArrayList.get(position).getDtTxt()));
        holder.dateText.setText(Utils.dayofweek(convertDateFormat(imageModelArrayList.get(position).getDtTxt())));
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView temText,dayText,dateText;

        public MyViewHolder(View itemView) {
            super(itemView);

            temText =  itemView.findViewById(R.id.tv);
            dayText=itemView.findViewById(R.id.day_text);
            dateText=itemView.findViewById(R.id.date_text);
        }

    }
}