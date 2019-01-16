/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;
import java.math.BigInteger;

/**
 *
 * @author Soultech
 */
public class FacturaPagoDTO {
    
    protected String idlinea;
    protected String businessunitname;
    protected String transactionsource;
    protected String transactiontype;
    protected String creationdatetrx;
    protected String creationdategl;
    protected String billtoconsumername;
    protected BigInteger billtolocation;
    protected Short paymenttermdays;
    protected String generationtype;
    protected BigInteger idfacturaprimavera;
    protected BigInteger linenumber;
    protected String memolinename;
    protected String description_origen;
    protected BigInteger quantity;
    protected BigInteger montobrutolinea;
    protected String clasificadordescuento;
    protected String descadicional1;
    protected String descadicional2;
    protected String descadicional3;
    protected String descadicional4;
    protected String descadicional5;
    protected String fechadesde;
    protected String fechahasta;
    protected String dffheadercontext;
    protected String fechaexigibilidad;
    protected BigInteger projectid;
    protected String folioavisocargo;
    protected String localnumber;
    protected String lineacaptura;
    protected Integer transactionID_ERP;
    protected String customerTrxID_ERP;
    protected String serviceStatus_ERP;
    
    

    public String getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(String idlinea) {
        this.idlinea = idlinea;
    }

    public String getBusinessunitname() {
        return businessunitname;
    }

    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
    }

    public String getTransactionsource() {
        return transactionsource;
    }

    public void setTransactionsource(String transactionsource) {
        this.transactionsource = transactionsource;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getCreationdatetrx() {
        return creationdatetrx;
    }

    public void setCreationdatetrx(String creationdatetrx) {
        this.creationdatetrx = creationdatetrx;
    }

    public String getCreationdategl() {
        return creationdategl;
    }

    public void setCreationdategl(String creationdategl) {
        this.creationdategl = creationdategl;
    }

    public String getBilltoconsumername() {
        return billtoconsumername;
    }

    public void setBilltoconsumername(String billtoconsumername) {
        this.billtoconsumername = billtoconsumername;
    }

    public BigInteger getBilltolocation() {
        return billtolocation;
    }

    public void setBilltolocation(BigInteger billtolocation) {
        this.billtolocation = billtolocation;
    }

    public Short getPaymenttermdays() {
        return paymenttermdays;
    }

    public void setPaymenttermdays(Short paymenttermdays) {
        this.paymenttermdays = paymenttermdays;
    }

    public String getGenerationtype() {
        return generationtype;
    }

    public void setGenerationtype(String generationtype) {
        this.generationtype = generationtype;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public BigInteger getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(BigInteger linenumber) {
        this.linenumber = linenumber;
    }

    public String getMemolinename() {
        return memolinename;
    }

    public void setMemolinename(String memolinename) {
        this.memolinename = memolinename;
    }

    public String getDescription_origen() {
        return description_origen;
    }

    public void setDescription_origen(String description_origen) {
        this.description_origen = description_origen;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getMontobrutolinea() {
        return montobrutolinea;
    }

    public void setMontobrutolinea(BigInteger montobrutolinea) {
        this.montobrutolinea = montobrutolinea;
    }

    public String getClasificadordescuento() {
        return clasificadordescuento;
    }

    public void setClasificadordescuento(String clasificadordescuento) {
        this.clasificadordescuento = clasificadordescuento;
    }

    public String getDescadicional1() {
        return descadicional1;
    }

    public void setDescadicional1(String descadicional1) {
        this.descadicional1 = descadicional1;
    }

    public String getDescadicional2() {
        return descadicional2;
    }

    public void setDescadicional2(String descadicional2) {
        this.descadicional2 = descadicional2;
    }

    public String getDescadicional3() {
        return descadicional3;
    }

    public void setDescadicional3(String descadicional3) {
        this.descadicional3 = descadicional3;
    }

    public String getDescadicional4() {
        return descadicional4;
    }

    public void setDescadicional4(String descadicional4) {
        this.descadicional4 = descadicional4;
    }

    public String getDescadicional5() {
        return descadicional5;
    }

    public void setDescadicional5(String descadicional5) {
        this.descadicional5 = descadicional5;
    }

    public String getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(String fechadesde) {
        this.fechadesde = fechadesde;
    }

    public String getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(String fechahasta) {
        this.fechahasta = fechahasta;
    }

    public String getDffheadercontext() {
        return dffheadercontext;
    }

    public void setDffheadercontext(String dffheadercontext) {
        this.dffheadercontext = dffheadercontext;
    }

    public String getFechaexigibilidad() {
        return fechaexigibilidad;
    }

    public void setFechaexigibilidad(String fechaexigibilidad) {
        this.fechaexigibilidad = fechaexigibilidad;
    }

    public BigInteger getProjectid() {
        return projectid;
    }

    public void setProjectid(BigInteger projectid) {
        this.projectid = projectid;
    }

    public String getFolioavisocargo() {
        return folioavisocargo;
    }

    public void setFolioavisocargo(String folioavisocargo) {
        this.folioavisocargo = folioavisocargo;
    }

    public String getLocalnumber() {
        return localnumber;
    }

    public void setLocalnumber(String localnumber) {
        this.localnumber = localnumber;
    }

    public String getLineacaptura() {
        return lineacaptura;
    }

    public void setLineacaptura(String lineacaptura) {
        this.lineacaptura = lineacaptura;
    }

    public Integer getTransactionID_ERP() {
        return transactionID_ERP;
    }

    public void setTransactionID_ERP(Integer transactionID_ERP) {
        this.transactionID_ERP = transactionID_ERP;
    }


    public String getServiceStatus_ERP() {
        return serviceStatus_ERP;
    }

    public void setServiceStatus_ERP(String serviceStatus_ERP) {
        this.serviceStatus_ERP = serviceStatus_ERP;
    }

    public String getCustomerTrxID_ERP() {
        return customerTrxID_ERP;
    }

    public void setCustomerTrxID_ERP(String customerTrxID_ERP) {
        this.customerTrxID_ERP = customerTrxID_ERP;
    }

    
}
