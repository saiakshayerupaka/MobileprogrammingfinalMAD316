package com.example.weather_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{


    private List<Weather> weathers;
    private Context context;
    private View.OnClickListener clickListener;

    public CustomAdapter(List<Weather> employees, Context context) {
        this.weathers = employees;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


            SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-mm-DD");
            Date date = null;
            try {
                date = inFormat.parse(weathers.get(position).getApplicable_date());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
            String goal = outFormat.format(date);

            if(position==0){
                holder.dayname.setText("Today");
            }
            else if(position==1){
                holder.dayname.setText("Tomorrow");

            }
            else {
                holder.dayname.setText(goal);
            }
            Glide.with(context)
                    .load("https://www.metaweather.com/static/img/weather/png/" + weathers.get(position).getWeather_state_abbr() + ".png")
                    .into(holder.dayweather_icon);

            holder.weather.setText(weathers.get(position).getWeather_state_name());


    }

    public void setOnClickListner(View.OnClickListener onClickListner)
    {
        clickListener = onClickListner;
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView dayweather_icon;
        TextView dayname,weather;
        LinearLayout list_itemm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dayweather_icon = itemView.findViewById(R.id.dayweather_icon);
            dayname = itemView.findViewById(R.id.day_name);
            weather = itemView.findViewById(R.id.weather);
            list_itemm = itemView.findViewById(R.id.list_itemm);


            itemView.setTag(this);
            itemView.setOnClickListener(clickListener);

        }
    }
}