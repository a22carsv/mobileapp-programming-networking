package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainViewHolder> {

    private ArrayList<Mountain> mountainList;

    public MountainAdapter(ArrayList<Mountain> mountainList) {
        this.mountainList = mountainList;
    }

    @NonNull
    @Override
    public MountainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a new MountainViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mountain, parent, false);
        return new MountainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainViewHolder holder, int position) {
        // Retrieve Mountain object at given position
        Mountain mountain = mountainList.get(position);

        // Bind Mountain data to ViewHolder
        holder.bind(mountain);
    }

    @Override
    public int getItemCount() {
        // Return items in the mountainList
        return mountainList.size();
    }
}
