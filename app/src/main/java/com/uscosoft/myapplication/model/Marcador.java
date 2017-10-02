package com.uscosoft.myapplication.model;

/**
 * Created by johnfevargas on 9/26/17.
 */

public class Marcador {



    String nombre;
    double  latitud;
     Double longitud;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
