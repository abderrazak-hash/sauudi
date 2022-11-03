package com.app.alshmalesalemalrwele;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapViewHolder> {

    private List<MapModel> mMap;
    private Context context ;





    public MapAdapter(Context context , List<MapModel> maps ) {
        this.context=context;
        this.mMap =maps ;

    }



    @NonNull
    @Override
    public MapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_map, parent, false);

        return new MapAdapter.MapViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MapViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.mapText.setText(mMap.get(position).getMapText());
        holder.mapText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(mMap.get(position).getMapUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMap.size();
    }

    public class MapViewHolder extends RecyclerView.ViewHolder {
        public Button mapText;

        public MapViewHolder(View view) {
            super(view);

            mapText = view.findViewById(R.id.btnMap);
        }
    }

}
