
package com.example.equipo_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrearEquipo extends AppCompatActivity {

    EditText edt_nombreE;
    EditText edt_ciudad;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
        else{
            Toast.makeText(CrearEquipo.this, "debes autenticarte primero", Toast.LENGTH_SHORT).show();
            FirebaseUser user = mAuth.getCurrentUser();
            //updateUI(user);
            Intent intent = new Intent(CrearEquipo.this, MainActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);
        edt_nombreE = (EditText) findViewById(R.id.edt_nombreE);
        edt_ciudad = (EditText) findViewById(R.id.edt_ciudad);
        mAuth = FirebaseAuth.getInstance();
    }

    public void CrearEquipo(View view) {
        String nombreEq = String.valueOf(edt_nombreE.getText());
        String ciudadE = String.valueOf(edt_ciudad.getText());
        Equipo e1 = new Equipo(nombreEq, ciudadE);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("equipos").child(e1.getNombreEquipo()).setValue(e1);
    }
}