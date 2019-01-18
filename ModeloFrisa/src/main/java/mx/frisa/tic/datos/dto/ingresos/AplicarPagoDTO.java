/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author USER_1
 */
public class AplicarPagoDTO {
    
    List<PagoPorAplicarDTO> pagoPorAplicar;

    public List<PagoPorAplicarDTO> getPagoPorAplicar() {
        return pagoPorAplicar;
    }

    public void setPagoPorAplicar(List<PagoPorAplicarDTO> pagoPorAplicar) {
        this.pagoPorAplicar = pagoPorAplicar;
    }
    
    
    
    
}
