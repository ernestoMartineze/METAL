/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soultech
 */
@Entity
@Table(name = "XXFR_LINEA_CAPTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrLineaCaptura.findAll", query = "SELECT x FROM XxfrLineaCaptura x")
    , @NamedQuery(name = "XxfrLineaCaptura.findByIdlineacaptura", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.idlineacaptura = :idlineacaptura")
    , @NamedQuery(name = "XxfrLineaCaptura.findByLineacapturaref", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.lineacapturaref = :lineacapturaref")
    , @NamedQuery(name = "XxfrLineaCaptura.findBySistemaorigen", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.sistemaorigen = :sistemaorigen")
    , @NamedQuery(name = "XxfrLineaCaptura.findByLineacaptura", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.lineacaptura = :lineacaptura")
    , @NamedQuery(name = "XxfrLineaCaptura.findByReferencia", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.referencia = :referencia")
    , @NamedQuery(name = "XxfrLineaCaptura.findByFechacreacion", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "XxfrLineaCaptura.findByFechavigencia", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.fechavigencia = :fechavigencia")
    , @NamedQuery(name = "XxfrLineaCaptura.findByMontolineacaptura", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.montolineacaptura = :montolineacaptura")
    , @NamedQuery(name = "XxfrLineaCaptura.findByEstatuslc", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.estatuslc = :estatuslc")
    , @NamedQuery(name = "XxfrLineaCaptura.findByBanco", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.banco = :banco")
    , @NamedQuery(name = "XxfrLineaCaptura.findByCuentabancaria", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.cuentabancaria = :cuentabancaria")
    , @NamedQuery(name = "XxfrLineaCaptura.findByEntidadlegal", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.entidadlegal = :entidadlegal")
    , @NamedQuery(name = "XxfrLineaCaptura.findByUnidadnegocio", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.unidadnegocio = :unidadnegocio")
    , @NamedQuery(name = "XxfrLineaCaptura.findByDivision", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.division = :division")
    , @NamedQuery(name = "XxfrLineaCaptura.findByCentrocostosproyecto", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.centrocostosproyecto = :centrocostosproyecto")
    , @NamedQuery(name = "XxfrLineaCaptura.findByNumerorecibo", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.numerorecibo = :numerorecibo")
    , @NamedQuery(name = "XxfrLineaCaptura.findByTipocobranza", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.tipocobranza = :tipocobranza")
    , @NamedQuery(name = "XxfrLineaCaptura.findByFolioacuerdocobranza", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.folioacuerdocobranza = :folioacuerdocobranza")
    , @NamedQuery(name = "XxfrLineaCaptura.findByMontoacuerdocobranza", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.montoacuerdocobranza = :montoacuerdocobranza")
    , @NamedQuery(name = "XxfrLineaCaptura.findByInteresmoratoriocondonado", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.interesmoratoriocondonado = :interesmoratoriocondonado")
    , @NamedQuery(name = "XxfrLineaCaptura.findByOrdinariocondonado", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.ordinariocondonado = :ordinariocondonado")
    , @NamedQuery(name = "XxfrLineaCaptura.findByCapitalrentacondonada", query = "SELECT x FROM XxfrLineaCaptura x WHERE x.capitalrentacondonada = :capitalrentacondonada")})
public class XxfrLineaCaptura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLINEACAPTURA")
    private BigDecimal idlineacaptura;
    @Size(max = 20)
    @Column(name = "LINEACAPTURAREF")
    private String lineacapturaref;
    @Size(max = 20)
    @Column(name = "SISTEMAORIGEN")
    private String sistemaorigen;
    @Size(max = 50)
    @Column(name = "LINEACAPTURA")
    private String lineacaptura;
    @Size(max = 20)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Column(name = "FECHAVIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavigencia;
    @Column(name = "MONTOLINEACAPTURA")
    private BigDecimal montolineacaptura;
    @Size(max = 20)
    @Column(name = "ESTATUSLC")
    private String estatuslc;
    @Size(max = 20)
    @Column(name = "BANCO")
    private String banco;
    @Size(max = 20)
    @Column(name = "CUENTABANCARIA")
    private String cuentabancaria;
    @Size(max = 20)
    @Column(name = "ENTIDADLEGAL")
    private String entidadlegal;
    @Size(max = 20)
    @Column(name = "UNIDADNEGOCIO")
    private String unidadnegocio;
    @Size(max = 20)
    @Column(name = "DIVISION")
    private String division;
    @Size(max = 20)
    @Column(name = "CENTROCOSTOSPROYECTO")
    private String centrocostosproyecto;
    @Size(max = 20)
    @Column(name = "NUMERORECIBO")
    private String numerorecibo;
    @Size(max = 20)
    @Column(name = "TIPOCOBRANZA")
    private String tipocobranza;
    @Size(max = 20)
    @Column(name = "FOLIOACUERDOCOBRANZA")
    private String folioacuerdocobranza;
    @Size(max = 20)
    @Column(name = "MONTOACUERDOCOBRANZA")
    private String montoacuerdocobranza;
    @Size(max = 20)
    @Column(name = "INTERESMORATORIOCONDONADO")
    private String interesmoratoriocondonado;
    @Size(max = 20)
    @Column(name = "ORDINARIOCONDONADO")
    private String ordinariocondonado;
    @Size(max = 20)
    @Column(name = "CAPITALRENTACONDONADA")
    private String capitalrentacondonada;

    public XxfrLineaCaptura() {
    }

    public XxfrLineaCaptura(BigDecimal idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public BigDecimal getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(BigDecimal idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public String getLineacapturaref() {
        return lineacapturaref;
    }

    public void setLineacapturaref(String lineacapturaref) {
        this.lineacapturaref = lineacapturaref;
    }

    public String getSistemaorigen() {
        return sistemaorigen;
    }

    public void setSistemaorigen(String sistemaorigen) {
        this.sistemaorigen = sistemaorigen;
    }

    public String getLineacaptura() {
        return lineacaptura;
    }

    public void setLineacaptura(String lineacaptura) {
        this.lineacaptura = lineacaptura;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechavigencia() {
        return fechavigencia;
    }

    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    public BigDecimal getMontolineacaptura() {
        return montolineacaptura;
    }

    public void setMontolineacaptura(BigDecimal montolineacaptura) {
        this.montolineacaptura = montolineacaptura;
    }

    public String getEstatuslc() {
        return estatuslc;
    }

    public void setEstatuslc(String estatuslc) {
        this.estatuslc = estatuslc;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuentabancaria() {
        return cuentabancaria;
    }

    public void setCuentabancaria(String cuentabancaria) {
        this.cuentabancaria = cuentabancaria;
    }

    public String getEntidadlegal() {
        return entidadlegal;
    }

    public void setEntidadlegal(String entidadlegal) {
        this.entidadlegal = entidadlegal;
    }

    public String getUnidadnegocio() {
        return unidadnegocio;
    }

    public void setUnidadnegocio(String unidadnegocio) {
        this.unidadnegocio = unidadnegocio;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCentrocostosproyecto() {
        return centrocostosproyecto;
    }

    public void setCentrocostosproyecto(String centrocostosproyecto) {
        this.centrocostosproyecto = centrocostosproyecto;
    }

    public String getNumerorecibo() {
        return numerorecibo;
    }

    public void setNumerorecibo(String numerorecibo) {
        this.numerorecibo = numerorecibo;
    }

    public String getTipocobranza() {
        return tipocobranza;
    }

    public void setTipocobranza(String tipocobranza) {
        this.tipocobranza = tipocobranza;
    }

    public String getFolioacuerdocobranza() {
        return folioacuerdocobranza;
    }

    public void setFolioacuerdocobranza(String folioacuerdocobranza) {
        this.folioacuerdocobranza = folioacuerdocobranza;
    }

    public String getMontoacuerdocobranza() {
        return montoacuerdocobranza;
    }

    public void setMontoacuerdocobranza(String montoacuerdocobranza) {
        this.montoacuerdocobranza = montoacuerdocobranza;
    }

    public String getInteresmoratoriocondonado() {
        return interesmoratoriocondonado;
    }

    public void setInteresmoratoriocondonado(String interesmoratoriocondonado) {
        this.interesmoratoriocondonado = interesmoratoriocondonado;
    }

    public String getOrdinariocondonado() {
        return ordinariocondonado;
    }

    public void setOrdinariocondonado(String ordinariocondonado) {
        this.ordinariocondonado = ordinariocondonado;
    }

    public String getCapitalrentacondonada() {
        return capitalrentacondonada;
    }

    public void setCapitalrentacondonada(String capitalrentacondonada) {
        this.capitalrentacondonada = capitalrentacondonada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineacaptura != null ? idlineacaptura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrLineaCaptura)) {
            return false;
        }
        XxfrLineaCaptura other = (XxfrLineaCaptura) object;
        if ((this.idlineacaptura == null && other.idlineacaptura != null) || (this.idlineacaptura != null && !this.idlineacaptura.equals(other.idlineacaptura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrLineaCaptura[ idlineacaptura=" + idlineacaptura + " ]";
    }
    
}
