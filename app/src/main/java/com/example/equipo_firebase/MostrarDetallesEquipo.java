package com.example.equipo_firebase;

import static com.example.equipo_firebase.clases.EquipoViewHolder.EXTRA_OBJETO_EQUIPO;
import static com.example.equipo_firebase.clases.EquipoViewHolder.EXTRA_OBJETO_EQUIPO_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MostrarDetallesEquipo extends AppCompatActivity {

    private EditText edtNombreE;
    private EditText edtCiudadE;
    private Equipo em;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_equipo);
        edtNombreE =(EditText) findViewById(R.id.edtNombreE);
        edtCiudadE = (EditText) findViewById(R.id.edtCiudadE);
        Intent intent = getIntent();
        if (intent != null) {
            em = (Equipo) intent.getSerializableExtra(EXTRA_OBJETO_EQUIPO);
            key = intent.getStringExtra(EXTRA_OBJETO_EQUIPO_KEY);
            edtNombreE.setText(em.getNombreEquipo());
            edtCiudadE.setText(em.getCiudad());
            }
            else{

            }
    }

    public void atras(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        FirebaseAuth.getInstance().signOut();
    }
}
