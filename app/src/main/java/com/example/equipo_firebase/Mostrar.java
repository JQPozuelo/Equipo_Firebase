package com.example.equipo_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Mostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
    }

    public void Crear(View view) {
        Intent intent = new Intent(this, CrearEquipo.class);
        startActivity(intent);
    }

    public void Mostrar(View view) {
        Intent intent = new Intent(this, MostrarEquipos.class);
        startActivity(intent);
    }

    public void ActuElim(View view) {
        Intent intent = new Intent(this, ActuElim.class);
        startActivity(intent);
    }
}