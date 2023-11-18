package org.example.datos.usuario;

import lombok.Data;

@Data
public class Incidente {
    private TipoIncidente tipoIncidente;
    private String descripcion;

    public Incidente(TipoIncidente tipoIncidente, String descripcion) {
        this.tipoIncidente = tipoIncidente;
        this.descripcion = descripcion;
    }

    public TipoIncidente getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(TipoIncidente tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
