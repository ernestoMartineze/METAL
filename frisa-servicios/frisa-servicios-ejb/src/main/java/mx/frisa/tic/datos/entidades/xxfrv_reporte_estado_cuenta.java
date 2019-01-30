/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;



import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRV_REPORTE_ESTADO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "xxfrv_reporte_estado_cuenta.findAll", query = "SELECT x FROM xxfrv_reporte_estado_cuenta x"),
    @NamedQuery(name = "xxfrv_reporte_estado_cuenta.findByUUID", query = "SELECT x FROM xxfrv_reporte_estado_cuenta x WHERE x.uuid = :uuid")})



/**
 *
 * @author USER_1
 */
public class xxfrv_reporte_estado_cuenta implements Serializable {
    @Id
    @Column(name = "ID_EDO_CTA")
    private BigInteger idEdoCta;

    private static final long serialVersionUID = 1L;
    
    @Column(name = "BANK_ACCOUNT_NUM")
    private BigInteger numeroCuenta;  
    
    @Column(name = "GL_DATE")
    private Date fechaTxn;  
    
    @Column(name = "RMETHODID")
    private String codigoError;  
    
    @Column(name = "UUID")
    private String uuid;  
    
    @Column(name = "DESCRIPCION")
    private String descripcionError;  

    public BigInteger getIdEdoCta() {
        return idEdoCta;
    }

    public void setIdEdoCta(BigInteger idEdoCta) {
        this.idEdoCta = idEdoCta;
    }

    public BigInteger getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(BigInteger numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaTxn() {
        return fechaTxn;
    }

    public void setFechaTxn(Date fechaTxn) {
        this.fechaTxn = fechaTxn;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    
}
