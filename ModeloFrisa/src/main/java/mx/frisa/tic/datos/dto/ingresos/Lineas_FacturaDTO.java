/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class Lineas_FacturaDTO {

    private List<LineaDTO> LineaDTO;

    public List<LineaDTO> getLineaDTO() {
        return LineaDTO;
    }

    public void setLineaDTO(List<LineaDTO> LineaDTO) {
        this.LineaDTO = LineaDTO;
    }
    
}
