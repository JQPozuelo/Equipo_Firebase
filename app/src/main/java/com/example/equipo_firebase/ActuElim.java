package com.example.equipo_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActuElim extends AppCompatActivity {

    EditText edtKeyAE;
    EditText edtActuENombre;
    EditText edtActuECiudad;
    private List<Equipo> equipos1;
    private List<String> keys1;
    private TextView txtMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actu_elim);
        edtKeyAE = (EditText) findViewById(R.id.edtKeyAE);
        edtActuENombre = (EditText) findViewById(R.id.edtActuENombre);
        edtActuECiudad = (EditText) findViewById(R.id.edtActuECiudad);
        txtMostrar = (TextView) findViewById(R.id.txtMostrar);
        //-----------------------------------------------
        equipos1 = new ArrayList<Equipo>();
        keys1 = new ArrayList<String>();
        //--------------------------------------------------
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        //--------------------------------------------------
        leerEquipo(new MyEquipos() {
            @Override
            public void leerequipos(List<String> keys, List<Equipo> equipos) {
                keys1 = keys;
                equipos1 = equipos;
                Log.i("firebasedb", "claves leidas");
                for(String k: keys1)
                {
                    Log.i("firebasedb", "clave leida " + k);
                    txtMostrar.setText(String.valueOf(txtMostrar.getText())+" -> " + k);

                }
                Log.i("firebasedb", "usuarios leidos");
                for(Equipo a: equipos1)
                {
                    Log.i("firebasedb", "equipo leido " + a.toString());
                    txtMostrar.setText(String.valueOf(txtMostrar.getText())+" -> " + a.toString());
                }
            }
        });
    }
    public interface MyEquipos{
        void leerequipos(List<String> keys, List<Equipo> equipos);
    }

    public void leerEquipo(MyEquipos misEquipos) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("equipos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> keys = new ArrayList<String>();
                List<Equipo> equipos = new ArrayList<Equipo>();
                for (DataSnapshot keynode : snapshot.getChildren()) {
                    keys.add(keynode.getKey());
                    equipos.add(keynode.getValue(Equipo.class));
                }
                Log.i("firebasedb", "claves leidas");
                for (String k : keys1) {
                    Log.i("firebasedb", "clave leida " + k);
                }
                Log.i("firebasedb", "usuarios leidos");
                for (Equipo a : equipos1) {
                    Log.i("firebasedb", "alumno leido " + a.toString());
                }
                misEquipos.leerequipos(keys, equipos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void EliminarEquipo(View view) {
        String key = String.valueOf(edtKeyAE.getText());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("equipos").child(key).removeValue();
        Toast.makeText(this,"borrado correcto ", Toast.LENGTH_LONG).show();
    }

    public void ActualizarEquipo(View view) {
        String clave = String.valueOf(edtKeyAE.getText());
        String nombre = String.valueOf(edtActuENombre.getText());
        String ciudad = String.valueOf(edtActuECiudad.getText());
        Equipo eqp = new Equipo(nombre,ciudad);
        Map<String, Object> nuevoEquipo = new HashMap<String,Object>();
        nuevoEquipo.put(clave,eqp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("equipos").updateChildren(nuevoEquipo);
        Toast.makeText(this,"actualizacion correcta",Toast.LENGTH_LONG).show();
    }
}
