/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

/**
 *
 * @author Ernesto
 */
public class ProcessInterfaceLineDTO {
    private String changeOperation;
    private InterfaceLineDTO InterfaceLineObject;

    public String getChangeOperation() {
     return changeOperation;
    }

    public InterfaceLineDTO getInterfaceLine() {
     return InterfaceLineObject;
    }

    // Setter Methods 

    public void setChangeOperation(String changeOperation) {
     this.changeOperation = changeOperation;
    }

    public void setInterfaceLine(InterfaceLineDTO interfaceLineObject) {
     this.InterfaceLineObject = interfaceLineObject;
    }

}
