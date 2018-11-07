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
package mx.frisa.tic.datos.comun;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.negocio.utils.ManejadorLog;


public class DAO<T> extends ManejadorEntidad implements Serializable {
    private static final long serialVersionUID = 70L;

    private final Class<T> entidad;//En esta variable se guarda una respuestaLineaCaptura generica
    private Proceso proceso = new Proceso("-1", "No existe información al criterio especificado");//En esta variable se guarda el estado del proceso actual

    /**
     * Creates a new instance of DAO
     * @param claseEntidad
     */
    public DAO(Class<T> claseEntidad) {
        this.entidad = claseEntidad;
        super.setEntidad(claseEntidad);

    }

    /**
     * Método que regresa una Lista generico de la clase enviada utilizando el
     * query nombrado sin parámetros.
     *
     * @return the List<T>
     * @param pQueryNamed
     */
    public List<T> consultaQueryNamed(String pQueryNamed) throws NonUniqueResultException,NoResultException {
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        List<T> listadoEntidad = new ArrayList<T>();
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            manejadorLog.debug("Consultado por : " + pQueryNamed);
            Query q = em.createNamedQuery(pQueryNamed);
            manejadorLog.debug("createNamedQuery : " + pQueryNamed);
            Object resultado = q.getResultList();
            manejadorLog.debug("resultado : Recuperado OKS:"+listadoEntidad.size());
            listadoEntidad = (List<T>) resultado;

            //Validando el termino de consulta
            if (!listadoEntidad.isEmpty()) {
                validarConsulta(listadoEntidad.size());
            }

        } catch (Exception ex) {
            manejadorLog.debug("Error en el método Entidad : " + ex.getMessage());
        } finally {
            manejadorLog.debug("Cerrando conexión!");
            em.close();
            cerrarManager();
        }

        return listadoEntidad;
    }

    
    public List<T> consultaQuery(String pQuery) throws NonUniqueResultException,NoResultException {
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        List<T> listadoEntidad = new ArrayList<T>();
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            manejadorLog.debug("Consultado por : " + pQuery);
            Query q = em.createQuery(pQuery);
            manejadorLog.debug("createQuery : " + pQuery);
            Object resultado = q.getResultList();
            manejadorLog.debug("resultado : " + resultado);
            listadoEntidad = (List<T>) resultado;

            //Validando el termino de consulta
            if (!listadoEntidad.isEmpty()) {
                validarConsulta(listadoEntidad.size());
            }

        } catch (Exception ex) {
            manejadorLog.error("Error en el método Entidad : " + ex.getMessage());
        } finally {
            manejadorLog.debug("Cerrando conexión!");
            em.close();
            cerrarManager();
        }

        return listadoEntidad;
    }

    public List<T> consultaQueryNativo(String pQuery) throws NonUniqueResultException,NoResultException {
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        List<T> listadoEntidad = new ArrayList<T>();
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            manejadorLog.debug("Consultado por : " + pQuery);
            Query q = em.createQuery(pQuery);
            manejadorLog.debug("createQuery : " + pQuery);
            
            listadoEntidad = q.getResultList();

            manejadorLog.debug("listadoEntidad : " + listadoEntidad);
           
            //Validando el termino de consulta
            if (!listadoEntidad.isEmpty()) {
                validarConsulta(listadoEntidad.size());
            }

        } catch (Exception ex) {
            manejadorLog.error("Error en el método Entidad : " + ex.getMessage());
        } finally {
            manejadorLog.debug("Cerrando conexión!");
            em.close();
            cerrarManager();
        }

        return listadoEntidad;
    }
    
        

    /**
     * Método que regresa una Lista generico de la clase enviada utilizando el
     * query nombrado con parámetros.
     *
     * @return the List<T>
     * @param pQueryNamed
     * @param plistaParametros
     * @exception Exception
     */
    public List<T> consultaQueryByParameters(String pQueryNamed, List<CatalogoParametroDTO> plistaParametros) throws NonUniqueResultException,NoResultException {
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        List<T> listadoEntidad = new ArrayList<T>();
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            manejadorLog.debug("Consultado por : " + pQueryNamed);

            Query q = em.createNamedQuery(pQueryNamed);
            
            int tamanioListaParametros = plistaParametros.size();
            for (int i = 0; i < tamanioListaParametros; i++) {
                manejadorLog.debug("Cargando parametro : " + plistaParametros.get(i).getDescripcion() + " = " + plistaParametros.get(i).getValor());
                if (CONSTANTE.CADENA.equals(plistaParametros.get(i).getTipo())) {
                    q.setParameter(plistaParametros.get(i).getDescripcion(), plistaParametros.get(i).getValor());
                }
                if (CONSTANTE.NUMERO.equals(plistaParametros.get(i).getTipo())) {
                    q.setParameter(plistaParametros.get(i).getDescripcion(), Integer.parseInt(plistaParametros.get(i).getValor()));
                }
            }

            Object resultado = q.getResultList();
            manejadorLog.debug("resultado : " + resultado);
            listadoEntidad = (List<T>) resultado;

            //Validando el termino de consulta
            if (!listadoEntidad.isEmpty()) {
                validarConsulta(listadoEntidad.size());
            }

        } catch (Exception ex) {
            manejadorLog.debug("Error en el método Entidad : " + ex.getMessage());
        } finally {
            manejadorLog.debug("Cerrando conexión!");
            em.close();
            this.cerrarManager();
        }

        return listadoEntidad;
    }
    
    public List<Object[]> consultaProcedimiento(
                                                                String idSolicitud
                                                                ){
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        ManejadorLog manejadorLog = new ManejadorLog();
         List<Object[]> listaRespuestaProcedimiento = new ArrayList<>();
            
        try {
            String procedure = "PCK_BUSCAR_SOLICITUD.CONSULTAR_SOLICITUD";
            manejadorLog.debug("Procedimiento : " + procedure);
           
            StoredProcedureQuery q = em.createStoredProcedureQuery(procedure);
            q.registerStoredProcedureParameter("P_ID_SOLICITUD", Integer.class, ParameterMode.IN);
            
            q.registerStoredProcedureParameter("PMENS_ERROR", String.class, ParameterMode.OUT);
           
            if(idSolicitud != null && !idSolicitud.isEmpty()){
                q.setParameter("P_ID_SOLICITUD",Integer.parseInt(idSolicitud));
            }
            q.execute();
            
            listaRespuestaProcedimiento = q.getResultList(); 
            
            //Validando el termino de consulta
            if (!listaRespuestaProcedimiento.isEmpty()) {
                validarConsulta(listaRespuestaProcedimiento.size());
            }
            
        } catch (Exception ex) {
            manejadorLog.debug("Error en el método Entidad : " + ex.getMessage());
        } finally {
            manejadorLog.debug("Cerrando conexión!");
            em.close();
            this.cerrarManager();
        }
        return listaRespuestaProcedimiento;
    }

   
    /**
     * Este método valida la consulta para conocer el termino de la consulta y
     * setear el proceso.
     *
     * @return the List<T>
     * @param pRowsClass
     */
    private void validarConsulta(int pRowsClass) {
        ManejadorLog manejadorLog = new ManejadorLog();
        if (pRowsClass < 1) {
            manejadorLog.debug("Retorna objeto vacio manejado");
            proceso.setTermino("9999");
            proceso.setDescripcion("No se encontraocute; informacion");
        } else {
            proceso.setTermino("0");
            proceso.setDescripcion("Exitoso");
        }
    }

    /**
     * Este método el mensaje retornado por la consulta, para setear el termino
     * del proceso
     *
     * @return the List<T>
     * @param pRowsClass
     */
    private void validarErrorInsert(boolean mensaje) {
        ManejadorLog manejadorLog = new ManejadorLog();
        if (mensaje) {
            manejadorLog.debug("Retorna objeto vacio manejado");
            proceso.setTermino("8888");
            proceso.setDescripcion("Contacte al administrador");
        } else {
            proceso.setTermino("0");
            proceso.setDescripcion("Exitoso");
        }
    }

    private void validarErrorActualiza(boolean mensaje) {
        ManejadorLog manejadorLog = new ManejadorLog();
        if (mensaje) {
            manejadorLog.debug("No actualizó la entidad");
            proceso.setTermino("9998");
            proceso.setDescripcion("Contacte al administrador entidad no actualizada");
        } else {
            proceso.setTermino("0");
            proceso.setDescripcion("Exitoso");
        }
    }

    public void registra(T entity) {
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        try {
            System.out.println("ENTIDAD: " + entity);
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();

            validarErrorInsert(false);
        } catch (Exception e) {
            validarErrorInsert(true);
            em.getTransaction().rollback();
        } finally {
            em.close();
            this.cerrarManager();
        }

    }
    
    
 

    public Boolean actualizaQuery(String scriptQuery) {
        this.instanciarManager();
        EntityManager em = this.getEntityManager();
        this.iniciaTransaccion(em.getTransaction());
        Boolean termina = false;
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            manejadorLog.debug("actualizaQuery: " + scriptQuery);

            em.createNativeQuery(scriptQuery);
            manejadorLog.debug("createNativeQuery");
            em.getTransaction().commit();
            manejadorLog.debug("commit");

            validarErrorActualiza(false);
            termina = true;
            manejadorLog.debug("Commit: OK ");
        } catch (RuntimeException e) {
            manejadorLog.debug("rollback: " + e.toString());
            validarErrorActualiza(true);
            em.getTransaction().rollback();
            termina = false;
        } finally {
            em.close();
            this.cerrarManager();
        }
        return termina;
    }

    /**
     * .
     * @return Proceso
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * @param proceso
     */
    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}
