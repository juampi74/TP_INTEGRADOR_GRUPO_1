package org.example.personas;


import lombok.Data;

@Data
public abstract class Persona {
    protected String nombre;
    protected String apellido;

    public void presentarse(){
        System.out.println(this.nombre+" "+this.apellido);
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
