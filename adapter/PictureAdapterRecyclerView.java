package com.carloscode97.pruebagram.adapter;

import android.app.Activity;
import android.graphics.Picture;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carloscode97.pruebagram.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecyclerView extends  RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{
    private ArrayList<com.carloscode97.pruebagram.model.Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<com.carloscode97.pruebagram.model.Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource,viewGroup,false);
        return new PictureViewHolder(view);
    }//Este metodo inicializa la clase PictureViewHolder

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int position) {
        com.carloscode97.pruebagram.model.Picture picture = pictures.get(position);
        pictureViewHolder.usernameCard.setText(picture.getUserName());
        pictureViewHolder.timeCard.setText(picture.getTime());
        pictureViewHolder.likeNumberCard.setText(picture.getLikeNumber());
        Picasso.get().load(picture.getPicture()).into(pictureViewHolder.pictureCard);
    }//Aqui se trabaja con todos los elementos del arraylist

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{
        private ImageView pictureCard;
        private TextView usernameCard;
        private  TextView timeCard;
        private TextView likeNumberCard;
        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);
            pictureCard     =   (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard    =   (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard        =   (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard  =   (TextView) itemView.findViewById(R.id.likeNumber);


        }
    }
}
