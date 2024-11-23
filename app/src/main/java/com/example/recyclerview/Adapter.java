package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    String[] title,description;
    int[] images;
    private static ClickListener clickListener;

    public Adapter(Context context, String[] title, String[] description, int[] images) {
        this.context = context;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.sample_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder.titleTextView.setText(title[i]);
        ViewHolder.descriptionTextView.setText(description[i]);
        ViewHolder.flowerImageView.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        static TextView titleTextView;
        static TextView descriptionTextView;
        static ImageView flowerImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.title_text_view);
            descriptionTextView=itemView.findViewById(R.id.description_text_view);
            flowerImageView=itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);;
        }

        @Override
        public void onClick(View v) {
             clickListener.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }
    public interface ClickListener{
        void onItemClick(int position,View v);
        void onItemLongClick(int position,View v);
    }
    public void setOnItemClickListener(ClickListener clickListener)
    {
        Adapter.clickListener=clickListener;
    }

}
