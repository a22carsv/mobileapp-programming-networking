package com.example.networking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MountainViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;

    public MountainViewHolder(@NonNull View itemView) {
        super(itemView);
        // Initialize nameTextView
        nameTextView = itemView.findViewById(R.id.text_view_name);
    }

    public void bind(Mountain mountain) {
        // Set name of the mountain to nameTextView
        nameTextView.setText(mountain.name);
        // Bind mountain properties to corresponding views
    }
}
