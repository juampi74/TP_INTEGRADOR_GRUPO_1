package org.example;

import org.example.areas_sociales.AreaComercial;
import org.example.areas_sociales.MesaAyuda;
import org.example.areas_sociales.RRHH;
import org.example.datos.empresa.Servicios;
import org.example.datos.tecnico.Especialidad;
import org.example.datos.tecnico.Notificacion;
import org.example.datos.tecnico.TipoEspecialidad;
import org.example.personas.Cliente;
import org.example.personas.Tecnico;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            //especialidad
        Especialidad especialidadEA = new Especialidad(TipoEspecialidad.EA);
        Especialidad especialidadEB = new Especialidad(TipoEspecialidad.EB);
        Especialidad especialidadEC = new Especialidad(TipoEspecialidad.EC);
        Especialidad especialidadED= new Especialidad(TipoEspecialidad.ED);

            //notificaciones
        Notificacion email = Notificacion.EMAIL;
        Notificacion whatsapp = Notificacion.WHATSAPP;

            //servicios
        Servicios sEmpresa = new Servicios("empresa");
        Servicios sCasa = new Servicios("casa");

            //técnico
        Tecnico tecnico = new Tecnico("Luz","Baldezari",especialidadEA,4,email);
        tecnico.agregarEspecialidad(especialidadEA);
        tecnico.agregarEspecialidad(especialidadEB);
        tecnico.agregarEspecialidad(especialidadEC);
        tecnico.agregarEspecialidad(especialidadED);
        Tecnico tecnico2 = new Tecnico("Lalo","Baldezari",especialidadEB,6,email);
        tecnico2.agregarEspecialidad(especialidadEB);
        Tecnico tecnico3 = new Tecnico("Juan","Rodriguez",especialidadEC,8,whatsapp);
        tecnico3.agregarEspecialidad(especialidadEC);
        Tecnico tecnico4 = new Tecnico("Facundo","Baldezari",especialidadED,4.5,whatsapp);
        tecnico4.agregarEspecialidad(especialidadED);
        tecnico4.agregarEspecialidad(especialidadEC);

            //cliente
        Cliente cliente = new Cliente("Mauro","Baldez","first","1");
        cliente.agregarServicio(sCasa);
        Cliente cliente2 = new Cliente("Tiago","Arbillaga","first","2");
        Cliente cliente3 = new Cliente("Rodrigo","Olmedo","second","3");
        Cliente cliente4 = new Cliente("Nahuel","Aramburu","second","4");

        cliente4.agregarServicio(sCasa);
        cliente4.agregarServicio(sEmpresa);
        //list's
        List<Tecnico> tecnicos = new ArrayList<>();
        tecnicos.add(tecnico);
        tecnicos.add(tecnico2);
        tecnicos.add(tecnico3);
        tecnicos.add(tecnico4);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);

            //rrhh
        RRHH rrhh = new RRHH(tecnicos);
        rrhh.bajaTecnico(tecnico2);
        rrhh.altaTecnico(tecnico4);

            //especialidad métodos
        especialidadEA.setTecnicosEspecialidad(tecnicos);
        especialidadEB.setTecnicosEspecialidad(tecnicos);
        especialidadEA.mostrarTecnicosDeLaEspecialidad();
        especialidadEB.mostrarTecnicosDeLaEspecialidad();

        //área comercial
        AreaComercial areaComercial = new AreaComercial(clientes);


        //mesa de ayuda
        MesaAyuda mesaAyuda = new MesaAyuda();
        mesaAyuda.setTecnicosMesa(tecnicos);
        mesaAyuda.setClientesMesa(clientes);

        //métodos mesa de ayuda
        mesaAyuda.atenderLlamada("first","1");

        mesaAyuda.agregarElIncidenteAlSistema();

        mesaAyuda.informarCliente();

        // pruebas SOUT
      /*  System.out.println("incidentes resueltos: "+tecnico2.getIncidentesResueltos());
        System.out.println("incidentes a cargo: "+tecnico2.getIncidentesACargo().size());
        System.out.println("clientes a cargo: "+tecnico2.getClientesACargo().size());
        System.out.println("Mails del cliente: "+cliente.getMails());
        tecnico2.resolverIncidente();
        System.out.println("----------------------------------------------------------");

        System.out.println("incidentes resueltos: "+tecnico2.getIncidentesResueltos());
        System.out.println("incidentes a cargo: "+tecnico2.getIncidentesACargo().size());
        System.out.println("notificaciones: "+tecnico2.getNotificacion());
        System.out.println("clientes a cargo: "+tecnico2.getClientesACargo().size());
        System.out.println("Mails del cliente: "+cliente.getMails());*/

    }
    // método técnico con Enum
}