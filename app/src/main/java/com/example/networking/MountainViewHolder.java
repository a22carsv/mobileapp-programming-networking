package com.example.networking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MountainViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;

    public MountainViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.text_view_name);
    }

    public void bind(Mountain mountain) {
        nameTextView.setText(mountain.name);
        // Bind other mountain properties to the corresponding views
    }
}
