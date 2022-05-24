package com.example.equipo_firebase.controladores;

import androidx.annotation.NonNull;

import com.example.equipo_firebase.Equipo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EquipoFirebaseController {
    private FirebaseDatabase mDatabase;
    private DatabaseReference myRef;
    private List<Equipo> equipos;

    public interface EquipoStatus
    {
        void equipoIsLoaded(List<Equipo> equipos, List<String> keys);
        void equipoIsAdd();
        void equipoIsUpdate();
        void equipoIsDelete();
    }
    public EquipoFirebaseController() {
        this.mDatabase  = FirebaseDatabase.getInstance();
        this.myRef = mDatabase.getReference("equipos");
        this.equipos  = new ArrayList<Equipo>();
    }
    //-------------------------------------------------------
    public void CargarEquipos(final EquipoStatus equipoStatus)
    {
        this.myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                equipos.clear();
                List<String> keys = new ArrayList<String>();
                for(DataSnapshot keynode: snapshot.getChildren())
                {
                    keys.add(keynode.getKey());
                    Equipo v = keynode.getValue(Equipo.class);
                    equipos.add(v);
                }
                equipoStatus.equipoIsLoaded(equipos,keys);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
