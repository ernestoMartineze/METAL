
package mx.frisa.tic.negocio.utils.interoperabilidad;

import java.io.Serializable;

/**
 * Todos los Derechos Reservados ó 2017 RUPA - gob.mx
 * RUPA.
 * Este software contiene información propiedad exclusiva de Presidencia de
 * Móxico
 * considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * ---------------------------------------------------------------------------
 * Sitio web: http://www.gob.mx
 * Nombre de Aplicación: RUPA
 * Nombre de archivo: RespuestaConsultaCurpDTO.java
 * Fecha de creación: 2017
 * Bitócora de modificaciones:
 * CR/Defecto Fecha Autor Descripción del cambio
 * ---------------------------------------------------------------------------
 * @author Soultech S. de R.L. de C.V.
 * @version 1.0
 * @created 20-jul.-2017 07:34:43 p. m.
 */
public class RespuestaConsultaCurpDTO implements Serializable{
        
        
        private static final long serialVersionUID = 8799656478674716003L;
	private String cURP;
	private String primarApellido;
	private String segundoApellido;
	private String nombre;
	private String sexo;
	private String fechaNacimiento;
	private String idEstado;
        private String descEstado;
        private String idError;
        private String descripcionError;
        

	public RespuestaConsultaCurpDTO(){
            //RespuestaConsultaCurpDTO sin propiedades necesarias
	}

    public RespuestaConsultaCurpDTO(String cURP, String primarApellido, String segundoApellido, String nombre, String sexo, String fechaNacimiento, String idEstado) {
        this.cURP = cURP;
        this.primarApellido = primarApellido;
        this.segundoApellido = segundoApellido;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.idEstado = idEstado;
    }

    public String getCURP() {
        return cURP;
    }

    public void setCURP(String cURP) {
        this.cURP = cURP;
    }

    public String getPrimarApellido() {
        return primarApellido;
    }

    public void setPrimarApellido(String primarApellido) {
        this.primarApellido = primarApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the descEstado
     */
    public String getDescEstado() {
        return descEstado;
    }

    /**
     * @param descEstado the descEstado to set
     */
    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }
        
        
      
}//end RespuestaConsultaCurpDTO