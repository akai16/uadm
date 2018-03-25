package com.example.saint.ultimoaplicativodomundo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saint.ultimoaplicativodomundo.R;
import com.example.saint.ultimoaplicativodomundo.adapter.RecyclerGIFAdapter;
import com.example.saint.ultimoaplicativodomundo.constants.UADMConstantes;
import com.example.saint.ultimoaplicativodomundo.entities.GifMock;
import com.example.saint.ultimoaplicativodomundo.interfaces.myListenerInterface;

import java.util.List;

public class ViceConsulFragment extends Fragment {

    ViewHolder mViewHolder = new ViewHolder();
    myListenerInterface listener;
    Context context;
    List<Integer> mGifList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_vice_consul, container, false);
        this.context = view.getContext();

        this.mViewHolder.mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_content);

        this.mGifList = GifMock.getGifList(UADMConstantes.VICECONSUL_GIF_LIST);
        RecyclerGIFAdapter mGifAdapter = new RecyclerGIFAdapter(this.mGifList,listener);
        this.mViewHolder.mRecyclerView.setAdapter(mGifAdapter);

        this.mViewHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.context));

        return view;
    }

    private static class ViewHolder
    {
        RecyclerView mRecyclerView;
    }
}
