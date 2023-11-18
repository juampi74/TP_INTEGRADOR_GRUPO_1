package org.example.areas_sociales;


import lombok.Data;
import org.example.personas.Tecnico;
import java.util.ArrayList;
import java.util.List;
@Data
public class RRHH {
   private List<Tecnico> tecnicosRrhh;

   public void altaTecnico(Tecnico t){
       this.tecnicosRrhh.add(t);
   }

   public void bajaTecnico(Tecnico t){
       this.tecnicosRrhh.remove(t);
   }
   public void modificarTecnico(Tecnico t){}

    public RRHH(List<Tecnico> tecnicos) {
        this.tecnicosRrhh = new ArrayList<>();
    }
}
