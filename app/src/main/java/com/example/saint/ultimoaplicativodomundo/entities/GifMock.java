package com.example.saint.ultimoaplicativodomundo.entities;

import com.example.saint.ultimoaplicativodomundo.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GifMock {

    public static List<Integer> getGifList(String personagem) {
        List<Integer> gifs = new ArrayList<>();
        Field[] drawables = R.drawable.class.getFields();

        for (Field f : drawables) {
            try {
                if(f.getName().startsWith(personagem)){
                    gifs.add(f.getInt(f.getName()) );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return gifs;
    }
}
