package com.example.equipo_firebase.clases;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.equipo_firebase.Equipo;
import com.example.equipo_firebase.MostrarDetallesEquipo;
import com.example.equipo_firebase.R;

import java.util.List;

public class EquipoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static final String EXTRA_OBJETO_EQUIPO = "es.jorge.equipoViewHolder.objeto_equipo";
    public static final String EXTRA_OBJETO_EQUIPO_KEY = "es.jorge.equipoViewHolder.objeto_equipo_key";
    public TextView txtNombreRv;
    public TextView txtCiudadRv;
    ListaEquiposAdapter lcAdapter;

    public EquipoViewHolder(@NonNull View itemView, ListaEquiposAdapter lcAdapter) {
        super(itemView);
        txtNombreRv = (TextView) itemView.findViewById(R.id.txtNombreRV);
        txtCiudadRv = (TextView) itemView.findViewById(R.id.txtCiudadRV);
        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();

        List<Equipo> equipos = this.lcAdapter.getListaEquipos();
        List<String> keys = this.lcAdapter.getKeys();
        Equipo equipo = equipos.get(mPosition);
        String key = keys.get(mPosition);
        Intent intent = new Intent(lcAdapter.getC(), MostrarDetallesEquipo.class);

        intent.putExtra(EXTRA_OBJETO_EQUIPO, equipo);
        intent.putExtra(EXTRA_OBJETO_EQUIPO_KEY, key);
        lcAdapter.getC().startActivity(intent);
    }
}
