package com.example.saint.ultimoaplicativodomundo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saint.ultimoaplicativodomundo.R;
import com.example.saint.ultimoaplicativodomundo.interfaces.myListenerInterface;
import com.example.saint.ultimoaplicativodomundo.viewholder.RecyclerGIFViewHolder;

import java.util.List;

public class RecyclerGIFAdapter extends RecyclerView.Adapter<RecyclerGIFViewHolder>{

    private List<Integer> mGifList;
    myListenerInterface listener;



    public RecyclerGIFAdapter(List<Integer> mGifList,myListenerInterface listener) {

        this.listener = listener;
        this.mGifList = mGifList;
    }

    @Override
    public RecyclerGIFViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gif_layout,parent,false);

        return new RecyclerGIFViewHolder(view,listener);

    }

    @Override
    public void onBindViewHolder(RecyclerGIFViewHolder holder, int position) {

        holder.onBindData(this.mGifList,position);
    }

    @Override
    public int getItemCount() {
        return this.mGifList.size();
    }
}
