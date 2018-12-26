/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author Soultech
 */
public class NotaCreditoListaDTO {
    
    Proceso proceso;
    List<CreditMemoDTO> notas;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<CreditMemoDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<CreditMemoDTO> notas) {
        this.notas = notas;
    }
    
    
}
