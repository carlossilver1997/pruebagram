package com.carloscode97.pruebagram.view.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carloscode97.pruebagram.R;
import com.carloscode97.pruebagram.adapter.PictureAdapterRecyclerView;
import com.carloscode97.pruebagram.model.Picture;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public HomeFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.home), false, view);
        RecyclerView pictureRecycler = (RecyclerView)view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pictureRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());
        pictureRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }
    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture>pictures = new ArrayList<Picture>();
        pictures.add(new Picture(
                "https://scontent-frx5-1.cdninstagram.com/vp/852caea1d4cfa98d775592ab0979b167/5DE445ED/t51.2885-19/50240784_291576494848605_5572575231672844288_n.jpg?_nc_ht=scontent-frx5-1.cdninstagram.com",
                "Uriel Ramirez",
                "4 dias",
                "50 Me gusta"
        ));
        pictures.add(new Picture(
                "https://scontent-frx5-1.cdninstagram.com/vp/d96be0c6d2ec1e368db1153b5971fb52/5DDAA1E6/t51.2885-19/65971216_947460218928949_3453309462972989440_n.jpg?_nc_ht=scontent-frx5-1.cdninstagram.com",
                "Cristiano Ronaldo",
                "3 dias",
                "1011 Me gusta"
        ));
        pictures.add(new Picture(
                "https://scontent-frx5-1.cdninstagram.com/vp/a92e1559836fe6486614433fd7e26072/5DD37941/t51.2885-19/36706279_692328434477427_6950564009116434432_n.jpg?_nc_ht=scontent-frx5-1.cdninstagram.com",
                "Kylian Mbappe",
                "4 dias",
                "110 me gusta"
        ));
        return pictures;
    }
    public void showToolbar(String title, boolean upButton ,View view){
        Toolbar toolbar = (Toolbar) view.findViewById( R.id.toolbar );
        ((AppCompatActivity) getActivity()).setSupportActionBar( toolbar );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
