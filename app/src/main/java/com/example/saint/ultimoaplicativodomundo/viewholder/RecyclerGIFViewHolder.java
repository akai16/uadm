package com.example.saint.ultimoaplicativodomundo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.saint.ultimoaplicativodomundo.R;
import com.example.saint.ultimoaplicativodomundo.interfaces.myListenerInterface;
import com.example.saint.ultimoaplicativodomundo.views.MainActivity;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class RecyclerGIFViewHolder extends RecyclerView.ViewHolder {

    private GifImageView mGif;
    myListenerInterface listener;

    public RecyclerGIFViewHolder(View itemView, myListenerInterface listener) {
        super(itemView);

        this.listener = listener;
        this.mGif = (GifImageView) itemView.findViewById(R.id.gif);
    }

    public void onBindData(List<Integer> gifList, int position) {
        this.mGif.setImageResource(gifList.get(position));
        this.mGif.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int id = view.getId();

                if (id == R.id.gif) {
                    listener.onGifsLongClickDo(0);
                }
                return false;
            }
        });
    }

}
