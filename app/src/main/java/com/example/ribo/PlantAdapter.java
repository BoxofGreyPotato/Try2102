package com.example.ribo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.try2102.R;

import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    private ArrayList<Plant> plants;

    public PlantAdapter(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = plants.get(position);

        holder.name.setText(plant.getName());
        holder.ranz.setText(plant.getRaznovidnost());
        holder.tepl.setText(plant.getTeplichnoe() ? "Тепличное" : "Не тепличное");
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ranz;
        TextView tepl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.ranz = itemView.findViewById(R.id.razn);
            this.tepl = itemView.findViewById(R.id.tepl);
        }
    }
}