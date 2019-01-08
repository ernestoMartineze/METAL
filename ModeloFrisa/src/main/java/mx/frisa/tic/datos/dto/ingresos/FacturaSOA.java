/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author USER_1
 */
public class FacturaSOA  {
 private float idfacturaprimavera;
 private String facilitynumber;
 private float companyaccountcode;
 private String businessunitname;
 private String transactionsource;
 private String transactiontype;
 private String creationdatetrx;
 private String creationdategl;
 private String currency;
 private String billtoconsumername;
 private float billtolocation;
 private float paymenttermdays;
 private String paymenttermdate;
 private float graceperiod;
 private String paymentmethod;
 private String dffheadercontext;
 private float contractnumber;
 private String contextrentas;
 private String localnumber;
 private String referencenumber;
 private String addendum;
 private String tipocobranza;
 private String divisiontype;
 private float projectid;
 private String generationtype;
 private String grouptype;
 private String bankname;
 private String bankaccountnumber;
 private float totalamount;
 private String idlineacaptura;
 private String estadoprocesamiento;
 private String idbatch;
 private float customerid;
 private float siteid;
 private String transactionid;
 private String orgid;
 private List<LineasFacturaSOA> Lineas;

    public List<LineasFacturaSOA> getLineas() {
        return Lineas;
    }

    public void setLineas(List<LineasFacturaSOA> Lineas) {
        this.Lineas = Lineas;
    }

 
 

 // Getter Methods 
 public float getIdfacturaprimavera() {
  return idfacturaprimavera;
 }

 public String getFacilitynumber() {
  return facilitynumber;
 }

 public float getCompanyaccountcode() {
  return companyaccountcode;
 }

 public String getBusinessunitname() {
  return businessunitname;
 }

 public String getTransactionsource() {
  return transactionsource;
 }

 public String getTransactiontype() {
  return transactiontype;
 }

 public String getCreationdatetrx() {
  return creationdatetrx;
 }

 public String getCreationdategl() {
  return creationdategl;
 }

 public String getCurrency() {
  return currency;
 }

 public String getBilltoconsumername() {
  return billtoconsumername;
 }

 public float getBilltolocation() {
  return billtolocation;
 }

 public float getPaymenttermdays() {
  return paymenttermdays;
 }

 public String getPaymenttermdate() {
  return paymenttermdate;
 }

 public float getGraceperiod() {
  return graceperiod;
 }

 public String getPaymentmethod() {
  return paymentmethod;
 }

 public String getDffheadercontext() {
  return dffheadercontext;
 }

 public float getContractnumber() {
  return contractnumber;
 }

 public String getContextrentas() {
  return contextrentas;
 }

 public String getLocalnumber() {
  return localnumber;
 }

 public String getReferencenumber() {
  return referencenumber;
 }

 public String getAddendum() {
  return addendum;
 }

 public String getTipocobranza() {
  return tipocobranza;
 }

 public String getDivisiontype() {
  return divisiontype;
 }

 public float getProjectid() {
  return projectid;
 }

 public String getGenerationtype() {
  return generationtype;
 }

 public String getGrouptype() {
  return grouptype;
 }

 public String getBankname() {
  return bankname;
 }

 public String getBankaccountnumber() {
  return bankaccountnumber;
 }

 public float getTotalamount() {
  return totalamount;
 }

 public String getIdlineacaptura() {
  return idlineacaptura;
 }

 public String getEstadoprocesamiento() {
  return estadoprocesamiento;
 }

 public String getIdbatch() {
  return idbatch;
 }

 public float getCustomerid() {
  return customerid;
 }

 public float getSiteid() {
  return siteid;
 }

 public String getTransactionid() {
  return transactionid;
 }

 public String getOrgid() {
  return orgid;
 }

 // Setter Methods 

 public void setIdfacturaprimavera(float idfacturaprimavera) {
  this.idfacturaprimavera = idfacturaprimavera;
 }

 public void setFacilitynumber(String facilitynumber) {
  this.facilitynumber = facilitynumber;
 }

 public void setCompanyaccountcode(float companyaccountcode) {
  this.companyaccountcode = companyaccountcode;
 }

 public void setBusinessunitname(String businessunitname) {
  this.businessunitname = businessunitname;
 }

 public void setTransactionsource(String transactionsource) {
  this.transactionsource = transactionsource;
 }

 public void setTransactiontype(String transactiontype) {
  this.transactiontype = transactiontype;
 }

 public void setCreationdatetrx(String creationdatetrx) {
  this.creationdatetrx = creationdatetrx;
 }

 public void setCreationdategl(String creationdategl) {
  this.creationdategl = creationdategl;
 }

 public void setCurrency(String currency) {
  this.currency = currency;
 }

 public void setBilltoconsumername(String billtoconsumername) {
  this.billtoconsumername = billtoconsumername;
 }

 public void setBilltolocation(float billtolocation) {
  this.billtolocation = billtolocation;
 }

 public void setPaymenttermdays(float paymenttermdays) {
  this.paymenttermdays = paymenttermdays;
 }

 public void setPaymenttermdate(String paymenttermdate) {
  this.paymenttermdate = paymenttermdate;
 }

 public void setGraceperiod(float graceperiod) {
  this.graceperiod = graceperiod;
 }

 public void setPaymentmethod(String paymentmethod) {
  this.paymentmethod = paymentmethod;
 }

 public void setDffheadercontext(String dffheadercontext) {
  this.dffheadercontext = dffheadercontext;
 }

 public void setContractnumber(float contractnumber) {
  this.contractnumber = contractnumber;
 }

 public void setContextrentas(String contextrentas) {
  this.contextrentas = contextrentas;
 }

 public void setLocalnumber(String localnumber) {
  this.localnumber = localnumber;
 }

 public void setReferencenumber(String referencenumber) {
  this.referencenumber = referencenumber;
 }

 public void setAddendum(String addendum) {
  this.addendum = addendum;
 }

 public void setTipocobranza(String tipocobranza) {
  this.tipocobranza = tipocobranza;
 }

 public void setDivisiontype(String divisiontype) {
  this.divisiontype = divisiontype;
 }

 public void setProjectid(float projectid) {
  this.projectid = projectid;
 }

 public void setGenerationtype(String generationtype) {
  this.generationtype = generationtype;
 }

 public void setGrouptype(String grouptype) {
  this.grouptype = grouptype;
 }

 public void setBankname(String bankname) {
  this.bankname = bankname;
 }

 public void setBankaccountnumber(String bankaccountnumber) {
  this.bankaccountnumber = bankaccountnumber;
 }

 public void setTotalamount(float totalamount) {
  this.totalamount = totalamount;
 }

 public void setIdlineacaptura(String idlineacaptura) {
  this.idlineacaptura = idlineacaptura;
 }

 public void setEstadoprocesamiento(String estadoprocesamiento) {
  this.estadoprocesamiento = estadoprocesamiento;
 }

 public void setIdbatch(String idbatch) {
  this.idbatch = idbatch;
 }

 public void setCustomerid(float customerid) {
  this.customerid = customerid;
 }

 public void setSiteid(float siteid) {
  this.siteid = siteid;
 }

 public void setTransactionid(String transactionid) {
  this.transactionid = transactionid;
 }

 public void setOrgid(String orgid) {
  this.orgid = orgid;
 }
}
