package com.example.equipo_firebase.clases;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.equipo_firebase.Equipo;
import com.example.equipo_firebase.R;


import java.util.ArrayList;
import java.util.List;

public class ListaEquiposAdapter extends RecyclerView.Adapter<EquipoViewHolder>{
    private Context c;
    private List<Equipo> listaEquipos;
    private List<String> keys;
    private LayoutInflater mInflater;

    public void setC(Context c) {
        this.c = c;
        this.listaEquipos = new ArrayList<Equipo>();
    }
    public ListaEquiposAdapter(Context c, List<Equipo> listaEquipos,List<String> keys) {
        this.c = c;
        this.listaEquipos = listaEquipos;
        this.keys = keys;
        mInflater = LayoutInflater.from(c);
    }

    public Context getC() {
        return c;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
        notifyDataSetChanged();
    }

    public ListaEquiposAdapter(Context c) {
        this.c = c;
        mInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public EquipoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_equipo, parent, false);
        return new EquipoViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipoViewHolder holder, int position) {
        if(listaEquipos!=null) {
            Equipo equipo_actual = listaEquipos.get(position);
            holder.txtCiudadRv.setText(String.valueOf("Nombre equipo: " + equipo_actual.getNombreEquipo()));
            holder.txtCiudadRv.setText(String.valueOf("Ciudad: " + equipo_actual.getCiudad()));

            }
            else{

            }
        }


    @Override
    public int getItemCount() {
        if (listaEquipos != null)
            return listaEquipos.size();
        else return 0;
    }
}
