/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import java.util.List;
import mx.frisa.tic.datos.dto.ingresos.Proceso;

/**
 *
 * @author USER_1
 */
public class RespuestaERP_Nota_Credito {

    String messageID;
    String CustomerTransactionId;
    String transactionNumber;
    Proceso proceso;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getCustomerTransactionId() {
        return CustomerTransactionId;
    }

    public void setCustomerTransactionId(String CustomerTransactionId) {
        this.CustomerTransactionId = CustomerTransactionId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }


    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}

