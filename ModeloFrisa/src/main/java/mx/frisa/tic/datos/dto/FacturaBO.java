package mx.frisa.tic.datos.dto;

import java.math.BigDecimal;

public class FacturaBO {
    protected BigDecimal idfacturaprimavera;
    protected BigDecimal contractnumber;
    protected String grouptype;
    protected String transactionsource;
    protected BigDecimal projectid;


    public void setIdfacturaprimavera(BigDecimal idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public BigDecimal getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setContractnumber(BigDecimal contractnumber) {
        this.contractnumber = contractnumber;
    }

    public BigDecimal getContractnumber() {
        return contractnumber;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setTransactionsource(String transactionsource) {
        this.transactionsource = transactionsource;
    }

    public String getTransactionsource() {
        return transactionsource;
    }

    public void setProjectid(BigDecimal projectid) {
        this.projectid = projectid;
    }

    public BigDecimal getProjectid() {
        return projectid;
    }
}
