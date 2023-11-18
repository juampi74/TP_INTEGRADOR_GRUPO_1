package org.example.areas_sociales;

import lombok.Data;
import org.example.personas.Cliente;
import org.example.personas.Tecnico;

import java.util.ArrayList;
import java.util.List;
@Data
public class AreaComercial {
    private List<Cliente> clienteList;

    public AreaComercial(List<Cliente> clienteList) {
        this.clienteList = new ArrayList<>();
    }

    public void agregarCliente(Cliente c){
        this.clienteList.add(c);
    }

    public void bajaCliente(Cliente c){
        this.clienteList.remove(c);
    }
    public void modificarCliente(Cliente c,Boolean estadoCliente){
        c.setEstadoDelCliente(estadoCliente);
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
}
