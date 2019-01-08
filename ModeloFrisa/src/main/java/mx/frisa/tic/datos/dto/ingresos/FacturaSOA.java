/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author USER_1
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FacturaSOA  {
 private Long idfacturaprimavera;
 private String facilitynumber;
 private Long companyaccountcode;
 private String businessunitname;
 private String transactionsource;
 private String transactiontype;
 private String creationdatetrx;
 private String creationdategl;
 private String currency;
 private String billtoconsumername;
 private Long billtolocation;
 private Long paymenttermdays;
 private String paymenttermdate;
 private Long graceperiod;
 private String paymentmethod;
 private String dffheadercontext;
 private Long contractnumber;
 private String contextrentas;
 private String localnumber;
 private String referencenumber;
 private String addendum;
 private String tipocobranza;
 private String divisiontype;
 private Integer projectid;
 private String generationtype;
 private String grouptype;
 private String bankname;
 private String bankaccountnumber;
 private Long totalamount;
 private String idlineacaptura;
 private String estadoprocesamiento;
 private String idbatch;
 private Long customerid;
 private Long siteid;
 private String transactionid;
 private String orgid;
 private String BATCHSOURCENAME;
 private List<LineasFacturaSOA> Lineas;

    public Long getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(Long idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getFacilitynumber() {
        return facilitynumber;
    }

    public void setFacilitynumber(String facilitynumber) {
        this.facilitynumber = facilitynumber;
    }

    public Long getCompanyaccountcode() {
        return companyaccountcode;
    }

    public void setCompanyaccountcode(Long companyaccountcode) {
        this.companyaccountcode = companyaccountcode;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBilltoconsumername() {
        return billtoconsumername;
    }

    public void setBilltoconsumername(String billtoconsumername) {
        this.billtoconsumername = billtoconsumername;
    }

    public Long getBilltolocation() {
        return billtolocation;
    }

    public void setBilltolocation(Long billtolocation) {
        this.billtolocation = billtolocation;
    }

    public Long getPaymenttermdays() {
        return paymenttermdays;
    }

    public void setPaymenttermdays(Long paymenttermdays) {
        this.paymenttermdays = paymenttermdays;
    }

    public String getPaymenttermdate() {
        return paymenttermdate;
    }

    public void setPaymenttermdate(String paymenttermdate) {
        this.paymenttermdate = paymenttermdate;
    }

    public Long getGraceperiod() {
        return graceperiod;
    }

    public void setGraceperiod(Long graceperiod) {
        this.graceperiod = graceperiod;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getDffheadercontext() {
        return dffheadercontext;
    }

    public void setDffheadercontext(String dffheadercontext) {
        this.dffheadercontext = dffheadercontext;
    }

    public Long getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(Long contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getContextrentas() {
        return contextrentas;
    }

    public void setContextrentas(String contextrentas) {
        this.contextrentas = contextrentas;
    }

    public String getLocalnumber() {
        return localnumber;
    }

    public void setLocalnumber(String localnumber) {
        this.localnumber = localnumber;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public String getAddendum() {
        return addendum;
    }

    public void setAddendum(String addendum) {
        this.addendum = addendum;
    }

    public String getTipocobranza() {
        return tipocobranza;
    }

    public void setTipocobranza(String tipocobranza) {
        this.tipocobranza = tipocobranza;
    }

    public String getDivisiontype() {
        return divisiontype;
    }

    public void setDivisiontype(String divisiontype) {
        this.divisiontype = divisiontype;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getGenerationtype() {
        return generationtype;
    }

    public void setGenerationtype(String generationtype) {
        this.generationtype = generationtype;
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccountnumber() {
        return bankaccountnumber;
    }

    public void setBankaccountnumber(String bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
    }

    public Long getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Long totalamount) {
        this.totalamount = totalamount;
    }

    public String getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(String idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public String getEstadoprocesamiento() {
        return estadoprocesamiento;
    }

    public void setEstadoprocesamiento(String estadoprocesamiento) {
        this.estadoprocesamiento = estadoprocesamiento;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public List<LineasFacturaSOA> getLineas() {
        return Lineas;
    }

    public void setLineas(List<LineasFacturaSOA> Lineas) {
        this.Lineas = Lineas;
    }

    public String getBATCHSOURCENAME() {
        return BATCHSOURCENAME;
    }

    public void setBATCHSOURCENAME(String BATCHSOURCENAME) {
        this.BATCHSOURCENAME = BATCHSOURCENAME;
    }

 
 
}
