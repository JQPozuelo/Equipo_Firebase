package com.example.equipo_firebase;

import java.io.Serializable;

public class Equipo implements Serializable {
    private String nombreEquipo;
    private String ciudad;
    //--------------------------------------------
    public Equipo(String nombreEquipo, String ciudad) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
    }

    public Equipo() {
        this.nombreEquipo = "se";
        this.ciudad = "se";
    }
    //-----------------------------------------------------

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    //------------------------------
    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
