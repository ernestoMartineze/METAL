/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.frisa.tic.negocio.utils.interoperabilidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ernesto
 */
@XmlRootElement(name="CURPStruct")
public class RespuestaCURP {

    private String CURP;
    private String apellido1;
    private String apellido2;
    private String nombres;
    private String sexo;
    private String fechNac;
    private String cveEntidadNac;
    private String nacionalidad;
    private String docProbatorio;
    private String anioReg;
    private String foja;
    private String tomo;
    private String libro;
    private String numActa;
    private String crip;
    private String numEntidadReg;
    private String cveMunicipioReg;
    private String NumRegExtranjeros;
    private String cveEntidadEmisora;
    private String FolioCarta;
    private String statusOper;
    private String message;
    private String TipoError;
    private String CodigoError;

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    @XmlElement(nillable = true)
    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechNac() {
        return fechNac;
    }

    public void setFechNac(String fechNac) {
        this.fechNac = fechNac;
    }

    public String getCveEntidadNac() {
        return cveEntidadNac;
    }

    public void setCveEntidadNac(String cveEntidadNac) {
        this.cveEntidadNac = cveEntidadNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDocProbatorio() {
        return docProbatorio;
    }

    public void setDocProbatorio(String docProbatorio) {
        this.docProbatorio = docProbatorio;
    }

    public String getAnioReg() {
        return anioReg;
    }

    public void setAnioReg(String anioReg) {
        this.anioReg = anioReg;
    }

    public String getFoja() {
        return foja;
    }

    public void setFoja(String foja) {
        this.foja = foja;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getNumActa() {
        return numActa;
    }

    public void setNumActa(String numActa) {
        this.numActa = numActa;
    }

    public String getCrip() {
        return crip;
    }

    public void setCrip(String crip) {
        this.crip = crip;
    }

    public String getNumEntidadReg() {
        return numEntidadReg;
    }

    public void setNumEntidadReg(String numEntidadReg) {
        this.numEntidadReg = numEntidadReg;
    }

    public String getCveMunicipioReg() {
        return cveMunicipioReg;
    }

    public void setCveMunicipioReg(String cveMunicipioReg) {
        this.cveMunicipioReg = cveMunicipioReg;
    }

    public String getNumRegExtranjeros() {
        return NumRegExtranjeros;
    }

    public void setNumRegExtranjeros(String NumRegExtranjeros) {
        this.NumRegExtranjeros = NumRegExtranjeros;
    }

    public String getCveEntidadEmisora() {
        return cveEntidadEmisora;
    }

    public void setCveEntidadEmisora(String cveEntidadEmisora) {
        this.cveEntidadEmisora = cveEntidadEmisora;
    }

    public String getFolioCarta() {
        return FolioCarta;
    }

    public void setFolioCarta(String FolioCarta) {
        this.FolioCarta = FolioCarta;
    }

    public String getStatusOper() {
        return statusOper;
    }

    public void setStatusOper(String statusOper) {
        this.statusOper = statusOper;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTipoError() {
        return TipoError;
    }

    public void setTipoError(String TipoError) {
        this.TipoError = TipoError;
    }

    public String getCodigoError() {
        return CodigoError;
    }

    public void setCodigoError(String CodigoError) {
        this.CodigoError = CodigoError;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CURP : ").append(this.CURP);
        sb.append("\nNombres: ").append(this.nombres);
        sb.append("\nApellido Uno: ").append(this.apellido1);
        sb.append("\nApellido Dos: ").append(this.apellido2);

        return sb.toString();

    }

}
