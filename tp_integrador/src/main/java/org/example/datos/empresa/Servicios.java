package org.example.datos.empresa;

import lombok.Data;

@Data
public class Servicios {
    private String nombre;

    public Servicios(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
