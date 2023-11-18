package org.example.personas;

import lombok.Data;
import org.example.datos.tecnico.Especialidad;
import org.example.datos.usuario.Incidente;
import org.example.datos.tecnico.Notificacion;
import org.example.datos.tecnico.TipoEspecialidad;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tecnico extends Persona{
    private Especialidad especialidad;
    private List<Especialidad> especialidades;
    private List<Incidente> incidentesACargo;
    private int incidentesResueltos;
    private List<Cliente> clientesACargo;
    private double tiempoEstimadoResolucion;
    private Notificacion notificacion;
    private Notificacion mediopreferido;
    public Tecnico(String nombre, String apellido, Especialidad especialidad, double tiempoEstimadoResolucion, Notificacion mediopreferido) {
        super(nombre, apellido);
        this.especialidad = especialidad;
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
        this.mediopreferido = mediopreferido;
        this.incidentesACargo = new ArrayList<>();
        this.clientesACargo = new ArrayList<>();
        this.especialidades=new ArrayList<>();

    }


    @Override
    public void presentarse() {
      String[] especialidades = this.especialidadesToArray();
        System.out.println("Mi nombre es "+this.nombre+" "+this.apellido+" soy técnico tipo: ");
        for (String s:especialidades){
            System.out.println("- "+s);
        }
    }

    public void agregarIncidente(Incidente e){
        this.incidentesACargo.add(e);
    }
    public void resolverIncidente(){
        this.incidentesACargo.remove(0);
        this.incidentesResueltos= this.incidentesResueltos+1;

        this.clientesACargo.get(0).setMails(this.clientesACargo.get(0).getMails()+1);
        this.clientesACargo.get(0).setEstadoDelCliente(true);
        this.clientesACargo.remove(0);

    }
    public void agregarCliente(Cliente c){
        this.clientesACargo.add(c);
    }
    public void agregarEspecialidad(Especialidad e){
        this.especialidades.add(e);
    }

    public String[] especialidadesToArray(){
        String [] especialidadesArray = new String[this.getEspecialidades().size()];
        for (int i = 0; i < this.getEspecialidades().size(); i++) {
            especialidadesArray[i]=this.getEspecialidades().get(i).getTipo().name();
        }

        return especialidadesArray;
    }
    public List<Incidente> getIncidentesACargo() {
        return incidentesACargo;
    }

    public void setIncidentesACargo(List<Incidente> incidentesACargo) {
        this.incidentesACargo = incidentesACargo;
    }

    public double getTiempoEstimadoResolucion() {
        return tiempoEstimadoResolucion;
    }

    public void setTiempoEstimadoResolucion(double tiempoEstimadoResolucion) {
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
    }

    public String getNotificacion() {
        if (notificacion==null){
            return "no hay ninguna notificación";
        }
        return notificacion.name();
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
    public TipoEspecialidad getEspecialidad() {
        return especialidad.getTipo();
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getIncidentesResueltos() {
        return incidentesResueltos;
    }

    public void setIncidentesResueltos(int incidentesResueltos) {
        this.incidentesResueltos = incidentesResueltos;
    }

    public List<Cliente> getClientesACargo() {
        return clientesACargo;
    }

    public void setClientesACargo(List<Cliente> clientesACargo) {
        this.clientesACargo = clientesACargo;
    }

    public Notificacion getMediopreferido() {
        return mediopreferido;
    }

    public void setMediopreferido(Notificacion mediopreferido) {
        this.mediopreferido = mediopreferido;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
}
