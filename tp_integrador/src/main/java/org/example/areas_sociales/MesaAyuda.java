package org.example.areas_sociales;

import lombok.Data;
import org.example.datos.usuario.Incidente;
import org.example.datos.usuario.TipoIncidente;
import org.example.personas.Cliente;
import org.example.personas.Tecnico;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Data
public class MesaAyuda {
    private List<Tecnico> tecnicosMesa;
    private List<Tecnico> tecnicosProcesados;
    private List<Cliente> clientesMesa;
    private List<Cliente> clientesProcesados;
    private List<Incidente> incidentesMesa;
    private double fechaLlamada;

    private int i;
    public void atenderLlamada(String razonSocial,String cuit){
        try{
            for (Cliente c : clientesMesa){
                if (c.getRazonSocial().equals(razonSocial) && c.getCuit().equals(cuit)) {
                    this.clientesProcesados.add(c);
                }
            } if (clientesProcesados.isEmpty()){
                System.out.println("no se encontró ningún cliente con los datos recibidos");
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("hubo un problema al responder su llamado");
            this.i=1;
        }

        while(this.i==0) {

            Scanner scannerLlamada = new Scanner(System.in);

            try {

                for (Cliente c: clientesProcesados){
                    if (c.getRazonSocial().equals(razonSocial) && c.getCuit().equals(cuit)) {
                        c.mostrarServicios();
                        String valorTipo = scannerLlamada.next().toLowerCase();

                        for (String s: c.serviciosToArray()){
                            if (valorTipo.equals(s)){
                                System.out.println("eligió "+s);
                                this.i=1;
                            }
                        }
                    }
                }
            }catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("ingese un servicio que tenga contratado...");
            }

        }
        this.i = 0;
    }

    public void agregarElIncidenteAlSistema() {
        while(this.i==0){
            try {
                Scanner scannerIncidente = new Scanner(System.in);
                System.out.println("índique su tipo de incidente: \nIA\nIB\nIC\nID");
                String tIncidente= scannerIncidente.next().toUpperCase();
                TipoIncidente tipoIncidenteCliente = TipoIncidente.valueOf(tIncidente);

                System.out.println("índique una breve descripción del dicho íncidente: ");
                String descripcionCliente = scannerIncidente.next();

                incidentesMesa.add(new Incidente(tipoIncidenteCliente, descripcionCliente));

                for (Tecnico t : tecnicosMesa) {

                    if (tipoIncidenteCliente.toString().equals("IA")) {
                        /* if (t.getEspecialidad().toString().equals("EA")) {
                            t.presentarse();
                            tecnicosProcesados.add(t);
                        }*/

                                // hacer con filter
                       String[] especialidades = t.especialidadesToArray();
                        int i=0;
                       for (String s:especialidades){
                           if (s.equals("EA")){
                               if (i==0){
                                   tecnicosProcesados.add(t);
                                   t.presentarse();
                                   i++;
                               }

                           }
                       }


                    } else if (tipoIncidenteCliente.toString().equals("IB")) {
                      /*  if (t.getEspecialidad().toString().equals("EB")) {
                            t.presentarse();
                            tecnicosProcesados.add(t);
                        }*/
                        String[] especialidades = t.especialidadesToArray();
                        int i=0;

                        for (String s:especialidades){
                            if (s.equals("EB")){
                                if (i==0){
                                    tecnicosProcesados.add(t);
                                    t.presentarse();
                                    i++;
                                }

                            }
                        }


                    } else if (tipoIncidenteCliente.toString().equals("IC")) {
                        /*if (t.getEspecialidad().toString().equals("EB") || t.getEspecialidad().toString().equals("EC")) {
                            t.presentarse();
                            tecnicosProcesados.add(t);
                        }*/
                        String[] especialidades = t.especialidadesToArray();
                        int i=0;
                        for (String s:especialidades){
                            if ( s.equals("EC") || s.equals("EB")){
                                if (i==0){
                                    tecnicosProcesados.add(t);
                                    t.presentarse();
                                    i++;
                                }

                            }
                        }

                    } else if (tipoIncidenteCliente.toString().equals("ID")) {
                       /* if (t.getEspecialidad().toString().equals("EC") || t.getEspecialidad().toString().equals("ED")) {
                            t.presentarse();
                            tecnicosProcesados.add(t);
                        } */
                        String[] especialidades = t.especialidadesToArray();
                        int i=0;
                        for (String s:especialidades){
                            if (s.equals("ED") || s.equals("EC")){
                                if (i==0){
                                    tecnicosProcesados.add(t);
                                    t.presentarse();
                                    i++;
                                }

                            }
                        }
                    }
                    this.i = 1;
                }
this.tecnicosProcesados.forEach(tecnico -> System.out.println(tecnico.getNombre()));
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
                System.out.println("ingrese un tipo de íncidente valido");

                this.i = 0;
            }
        }
        this.i=0;
    }

    public void informarCliente(){
            try{
                //informe al cliente
                tecnicosProcesados.get(0).agregarIncidente(incidentesMesa.get(0));
                tecnicosProcesados.get(0).agregarCliente(clientesProcesados.get(0));
                tecnicosProcesados.get(0).setNotificacion(tecnicosProcesados.get(0).getMediopreferido());
                System.out.println("el tiempo estimado de resolución del técnico seleccionado: "+tecnicosProcesados.get(0).getNombre()+" "+tecnicosProcesados.get(0).getApellido()+"\n"+
                        "es de: "+tecnicosProcesados.get(0).getTiempoEstimadoResolucion()+" horas");
                //hora de resolución
                fechaLlamada = LocalDateTime.now().getHour();
                double fechaFinal = fechaLlamada +tecnicosProcesados.get(0).getTiempoEstimadoResolucion();

                System.out.println("por lo tanto la hora estimada de resolución es: "+fechaFinal+"hs");
                this.i=1;

            }catch (Exception e){
                System.out.println("ocurrió un problema con su consulta, en breve lo solucionaremos");
                System.out.println("error: "+e.getMessage());
                this.i=0;
            }
    }



    public MesaAyuda() {
        this.tecnicosMesa = new ArrayList<>();
        this.clientesMesa = new ArrayList<>();
        this.clientesProcesados = new ArrayList<>();
        this.incidentesMesa = new ArrayList<>();
        this.tecnicosProcesados = new ArrayList<>();
    }

    public List<Tecnico> getTecnicosMesa() {
        return tecnicosMesa;
    }

    public void setTecnicosMesa(List<Tecnico> tecnicosMesa) {
        this.tecnicosMesa = tecnicosMesa;
    }

    public List<Cliente> getClientesMesa() {
        return clientesMesa;
    }

    public void setClientesMesa(List<Cliente> clientesMesa) {
        this.clientesMesa = clientesMesa;
    }

    public List<Incidente> getIncidentesMesa() {
        return incidentesMesa;
    }

    public void setIncidentesMesa(List<Incidente> incidentesMesa) {
        this.incidentesMesa = incidentesMesa;
    }

    public double getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(double fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }
}
