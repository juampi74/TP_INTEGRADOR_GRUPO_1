package org.example.personas;

import lombok.Data;
import org.example.datos.empresa.Servicios;
import org.example.datos.usuario.Incidente;
import org.example.datos.usuario.TipoIncidente;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente extends Persona{
    private Incidente incidenteCliente;
    private Boolean estadoDelCliente;
    private String razonSocial;
    private String cuit;
    private int mails= 0;
    private List<Servicios> serviciosContratados;
    public Cliente(String nombre, String apellido,String razonSocial,String cuit) {
        super(nombre, apellido);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.serviciosContratados = new ArrayList<>();
    }

    public void agregarIncidente(String nombreInc, TipoIncidente tipo, String desc){
      this.incidenteCliente = new Incidente(tipo,desc);
    }
    public void agregarServicio(Servicios s){
        serviciosContratados.add(s);
    }
    public void mostrarServicios(){
        if (this.serviciosContratados.isEmpty()){
            System.out.println("no tiene ningún servicio contratado");
        }else {
            System.out.println("por cual de estos servicios desea reportar un incidente (ponga el nombre): ");
            this.serviciosContratados.forEach(servicios -> System.out.println("- "+servicios.getNombre()));
        }

    }
    public String[] serviciosToArray(){
        String [] serviciosContratadosArray = new String[serviciosContratados.size()];
        for (int i = 0; i < serviciosContratados.size(); i++) {
            serviciosContratadosArray[i]=serviciosContratados.get(i).getNombre();
        }

        return serviciosContratadosArray;
    }


    public Boolean getEstadoDelCliente() {
        return estadoDelCliente;
    }

    public void setEstadoDelCliente(Boolean estadoDelCliente) {
        this.estadoDelCliente = estadoDelCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Incidente getIncidenteCliente() {
        return incidenteCliente;
    }

    public void setIncidenteCliente(Incidente incidenteCliente) {
        this.incidenteCliente = incidenteCliente;
    }

    public int getMails() {
        return mails;
    }

    public void setMails(int mails) {
        this.mails = mails;
    }

    public List<Servicios> getServiciosContratados() {
         return serviciosContratados;
    }

    public void setServiciosContratados(List<Servicios> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
}
