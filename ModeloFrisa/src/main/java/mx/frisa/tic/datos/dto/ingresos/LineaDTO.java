/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Ernesto
 */
public class LineaDTO {
    
    private String LineType;
    private String MemoLineName;
    private Integer Quantity;
    private BigDecimal UnitSellingPrice;
    private String TaxCode;
    private BigInteger MontoIVALinea;
    private BigInteger taxCodeRetIva;
    private BigInteger MontotaxCodeRetIva;
    private BigInteger taxCodoRetISR;
    private BigInteger MontotaxCodoRetISR;
    private String descripOrigen;
    private String descripManual;
    private String descripciOnAdicional1;
    private String descripciOnAdicional2;
    private String descripciOnAdicional3;
    private String descripciOnAdicional4;
    private String descripciOnAdicional5;
    private String periodoDeFacturacionDesde;
    private String periodoDeFacturacionHasta;
    private String siguienteFechaDeExigibilidad;
    private BigInteger orderNumber;
    private short orderLineNumber;
    private String flexContext;
    private String flexContextDisplayvalue;
    private String flexNumofsegments;


    public String getLineType() {
        return LineType;
    }

    public void setLineType(String LineType) {
        this.LineType = LineType;
    }

    public String getMemoLineName() {
        return MemoLineName;
    }

    public void setMemoLineName(String MemoLineName) {
        this.MemoLineName = MemoLineName;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public BigDecimal getUnitSellingPrice() {
        return UnitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal UnitSellingPrice) {
        this.UnitSellingPrice = UnitSellingPrice;
    }

    public String getTaxCode() {
        return TaxCode;
    }

    public void setTaxCode(String TaxCode) {
        this.TaxCode = TaxCode;
    }

    public BigInteger getMontoIVALinea() {
        return MontoIVALinea;
    }

    public void setMontoIVALinea(BigInteger MontoIVALinea) {
        this.MontoIVALinea = MontoIVALinea;
    }

    public BigInteger getTaxCodeRetIva() {
        return taxCodeRetIva;
    }

    public void setTaxCodeRetIva(BigInteger taxCodeRetIva) {
        this.taxCodeRetIva = taxCodeRetIva;
    }

    public BigInteger getMontotaxCodeRetIva() {
        return MontotaxCodeRetIva;
    }

    public void setMontotaxCodeRetIva(BigInteger MontotaxCodeRetIva) {
        this.MontotaxCodeRetIva = MontotaxCodeRetIva;
    }

    public BigInteger getTaxCodoRetISR() {
        return taxCodoRetISR;
    }

    public void setTaxCodoRetISR(BigInteger taxCodoRetISR) {
        this.taxCodoRetISR = taxCodoRetISR;
    }

    public BigInteger getMontotaxCodoRetISR() {
        return MontotaxCodoRetISR;
    }

    public void setMontotaxCodoRetISR(BigInteger MontotaxCodoRetISR) {
        this.MontotaxCodoRetISR = MontotaxCodoRetISR;
    }

    public String getDescripOrigen() {
        return descripOrigen;
    }

    public void setDescripOrigen(String descripOrigen) {
        this.descripOrigen = descripOrigen;
    }

    public String getDescripManual() {
        return descripManual;
    }

    public void setDescripManual(String descripManual) {
        this.descripManual = descripManual;
    }

    public String getDescripciOnAdicional1() {
        return descripciOnAdicional1;
    }

    public void setDescripciOnAdicional1(String descripciOnAdicional1) {
        this.descripciOnAdicional1 = descripciOnAdicional1;
    }

    public String getDescripciOnAdicional2() {
        return descripciOnAdicional2;
    }

    public void setDescripciOnAdicional2(String descripciOnAdicional2) {
        this.descripciOnAdicional2 = descripciOnAdicional2;
    }

    public String getDescripciOnAdicional3() {
        return descripciOnAdicional3;
    }

    public void setDescripciOnAdicional3(String descripciOnAdicional3) {
        this.descripciOnAdicional3 = descripciOnAdicional3;
    }

    public String getDescripciOnAdicional4() {
        return descripciOnAdicional4;
    }

    public void setDescripciOnAdicional4(String descripciOnAdicional4) {
        this.descripciOnAdicional4 = descripciOnAdicional4;
    }

    public String getDescripciOnAdicional5() {
        return descripciOnAdicional5;
    }

    public void setDescripciOnAdicional5(String descripciOnAdicional5) {
        this.descripciOnAdicional5 = descripciOnAdicional5;
    }

    public String getPeriodoDeFacturacionDesde() {
        return periodoDeFacturacionDesde;
    }

    public void setPeriodoDeFacturacionDesde(String periodoDeFacturacionDesde) {
        this.periodoDeFacturacionDesde = periodoDeFacturacionDesde;
    }

    public String getPeriodoDeFacturacionHasta() {
        return periodoDeFacturacionHasta;
    }

    public void setPeriodoDeFacturacionHasta(String periodoDeFacturacionHasta) {
        this.periodoDeFacturacionHasta = periodoDeFacturacionHasta;
    }

    public String getSiguienteFechaDeExigibilidad() {
        return siguienteFechaDeExigibilidad;
    }

    public void setSiguienteFechaDeExigibilidad(String siguienteFechaDeExigibilidad) {
        this.siguienteFechaDeExigibilidad = siguienteFechaDeExigibilidad;
    }

    public BigInteger getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigInteger orderNumber) {
        this.orderNumber = orderNumber;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public String getFlexContext() {
        return flexContext;
    }

    public void setFlexContext(String flexContext) {
        this.flexContext = flexContext;
    }

    public String getFlexContextDisplayvalue() {
        return flexContextDisplayvalue;
    }

    public void setFlexContextDisplayvalue(String flexContextDisplayvalue) {
        this.flexContextDisplayvalue = flexContextDisplayvalue;
    }

    public String getFlexNumofsegments() {
        return flexNumofsegments;
    }

    public void setFlexNumofsegments(String flexNumofsegments) {
        this.flexNumofsegments = flexNumofsegments;
    }
    
    
}
