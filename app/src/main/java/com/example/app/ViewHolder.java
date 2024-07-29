package com.example.app;
import androidx.recyclerview.widget.RecyclerView;
import  android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public  class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;




    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        textView = itemView.findViewById(R.id.imagetext);
;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
