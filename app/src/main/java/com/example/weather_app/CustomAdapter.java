package com.example.weather_app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context context;

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
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

        }
    }
}
