package com.example.equipo_firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.equipo_firebase.clases.ListaEquiposAdapter;
import com.example.equipo_firebase.controladores.EquipoFirebaseController;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MostrarEquipos extends AppCompatActivity {
    private RecyclerView rv_Equipos = null;
    private ListaEquiposAdapter mAdapter;
    private ArrayList<Equipo> equipos;
    private ArrayList<String> keys;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_equipos);
        mAuth = FirebaseAuth.getInstance();
        rv_Equipos = findViewById(R.id.rv_Equipos);
        mAdapter = new ListaEquiposAdapter(this);
        new EquipoFirebaseController().CargarEquipos(new EquipoFirebaseController.EquipoStatus() {
            @Override
            public void equipoIsLoaded(List<Equipo> equipos, List<String> keys) {
                mAdapter.setListaEquipos(equipos);
                mAdapter.setKeys(keys);
            }

            @Override
            public void equipoIsAdd() {

            }

            @Override
            public void equipoIsUpdate() {

            }

            @Override
            public void equipoIsDelete() {

            }

        });

        //------------------------------------------------------------
        rv_Equipos.setAdapter(mAdapter);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rv_Equipos.setLayoutManager(new LinearLayoutManager(this));
        } else {

        }

        //------------------------------------------------------------
    }
}