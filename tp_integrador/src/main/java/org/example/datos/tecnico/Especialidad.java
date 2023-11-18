package org.example.datos.tecnico;

import lombok.Data;
import org.example.personas.Tecnico;

import java.util.ArrayList;
import java.util.List;
@Data
public class Especialidad {
    private TipoEspecialidad tipoEspecialidad;
    private List<Tecnico> tecnicosEspecialidad;

    public void mostrarTecnicosDeLaEspecialidad(){
        for(Tecnico t: tecnicosEspecialidad){
            if(t.getEspecialidad().equals(this.getTipo())){
                t.presentarse();
            }
        }
    }

    public Especialidad(TipoEspecialidad tipo) {
        this.tipoEspecialidad = tipo;
        this.tecnicosEspecialidad = new ArrayList<>();
    }

    public TipoEspecialidad getTipo() {
        return tipoEspecialidad;
    }

    public void setTipo(TipoEspecialidad tipo) {
        this.tipoEspecialidad = tipo;
    }

    public List<Tecnico> getTecnicosEspecialidad() {
        return tecnicosEspecialidad;
    }

    public void setTecnicosEspecialidad(List<Tecnico> tecnicosEspecialidad) {
        this.tecnicosEspecialidad = tecnicosEspecialidad;
    }
}
