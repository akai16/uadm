package com.example.saint.ultimoaplicativodomundo.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
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

public class DanielGifsFragment extends Fragment {

    ViewHolder mViewHolder = new ViewHolder();
    List<Integer> mGifList;
    Context context;

    myListenerInterface listener = new myListenerInterface() {
        @Override
        public void onGifsLongClickDo(int id) {
            CharSequence options[] = new CharSequence[] {"Compartilhar","Levar um tapa na cara","Tomar no cu, tua puta"};

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Ações");
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which==0)
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        startActivity(intent);
                    }
                }
            });
            builder.show();
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mGifList = GifMock.getGifList(UADMConstantes.DANIEL_GIF_LIST);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daniel_gifs, container, false);
        this.context = view.getContext();

        //1- Obter Recycler
        this.mViewHolder.mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_content);

        //2-Definir adapter
        RecyclerGIFAdapter mGifAdapter = new RecyclerGIFAdapter(mGifList,listener);
        this.mViewHolder.mRecyclerView.setAdapter(mGifAdapter);

        //3-Definir layout
        this.mViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(this.context,2));

        return view;
    }



    private static class ViewHolder {

        RecyclerView mRecyclerView;
    }
}
