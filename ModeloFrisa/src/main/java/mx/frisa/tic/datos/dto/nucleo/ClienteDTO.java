/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.nucleo;

/**
 *
 * @author soultech
 */
public class ClienteDTO {
    
    String clienteId;
    String clienteArId;
    String nombre;
    String numeroPieza;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteArId() {
        return clienteArId;
    }

    public void setClienteArId(String clienteArId) {
        this.clienteArId = clienteArId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroPieza() {
        return numeroPieza;
    }

    public void setNumeroPieza(String paryNumber) {
        this.numeroPieza = paryNumber;
    }
    
    
    
}
