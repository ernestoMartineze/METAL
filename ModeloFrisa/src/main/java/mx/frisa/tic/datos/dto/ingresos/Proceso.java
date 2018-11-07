/**
 * Todos los Derechos Reservados © 2018 FRISA.
 * Este software contiene información propiedad exclusiva de Soultech.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * -----------------------------------------------------------------------------------------------------------------
 * Sitio web: http://
 * Nombre de Aplicación: FRISA-PTF
 * Nombre de archivo: DAO.java
 * Fecha de creación: 2018
 *
 * @author: Soultech S de RL de CV
 * @version 1.0
 *
 * Bitácora de modificaciones: CR/Defecto Fecha Autor Descripción del cambio
 * -----------------------------------------------------------------------------------------------------------------
 * Creación 2017 Ernesto Martinez Espinosa Creacion
 *
 */

package mx.frisa.tic.datos.dto.ingresos;

import java.io.Serializable;

public class Proceso implements Serializable{
        private static final long serialVersionUID = 190512204300007L;
	private String descripcion;
	private String termino;

        public Proceso(){
            //Proceso sin propiedades necesarias
        }
        
	/**
	 * 
	 * @param termino
	 * @param descripcion
	 */
	public Proceso(String termino, String descripcion){
               this.descripcion = descripcion;
               this.termino = termino;
	}

	

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the termino
     */
    public String getTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(String termino) {
        this.termino = termino;
    }
}//end Proceso