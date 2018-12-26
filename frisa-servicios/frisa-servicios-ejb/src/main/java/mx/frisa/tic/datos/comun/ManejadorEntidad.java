/**
 * Todos los Derechos Reservados © 2017 RUPA.
 * Este software contiene información propiedad exclusiva de Presidencia de México considerada Confidencial.
 * Queda totalmente prohibido su uso o divulgación en forma parcial o total.
 * -----------------------------------------------------------------------------------------------------------------
 * Sitio web: http://www.gob.mx
 * Nombre de Aplicación: RUPA
 * Nombre de archivo: ManejadorEntidad.java
 * Fecha de creación: 2017
 *
 * @author: Soultech S de RL de CV
 * @version 1.0
 *
 * Bitácora de modificaciones: CR/Defecto Fecha Autor Descripción del cambio
 * -----------------------------------------------------------------------------------------------------------------
 * Creación 2017 Ernesto Martinez Espinoza Creacion
 *
 */
package mx.frisa.tic.datos.comun;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.frisa.tic.negocio.utils.ManejadorLog;

public class ManejadorEntidad<T> {

//    @PersistenceContext(unitName = "RUPADEVDBPU")
    private EntityManager em;
    private EntityManagerFactory emf; //= Persistence.createEntityManagerFactory("Portal_CUSTFPU");
    private EntityTransaction et;

    private Class<T> entidad;

    public Class<T> getEntidad() {
        return entidad;
    }

    public void setEntidad(Class<T> entidad) {
        this.entidad = entidad;
    }

    public EntityManager getEntityManager() {
        ManejadorLog manejadorLog = new ManejadorLog();
        em = emf.createEntityManager();//Instancia 
        manejadorLog.debug("EntityManager: " + em);
        return em;
    }

    protected EntityTransaction getEntityTransaccion(EntityManager em) {
        et = em.getTransaction();
        return et;
    }

    protected java.sql.Connection getConexionJPA() {
        em.getTransaction().begin();
        java.sql.Connection connection = em.unwrap(java.sql.Connection.class); // unwraps the Connection class.
        return connection;
    }

    public void instanciarManager() {
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            emf = Persistence.createEntityManagerFactory("FRISADBPU");;
            manejadorLog.debug("instanciarManager OK");

        } catch (Exception e) {
            manejadorLog.debug("##### error instanciarManager :" + e.getMessage());

        }
    }

    public void iniciaTransaccion(EntityTransaction et) {
        et.begin();
    }

    public void generarCommit(EntityTransaction et) {
        et.commit();
    }

    public void generarRollback(EntityTransaction et) {
        et.rollback();
    }

    public void cerrarManager() {
        ManejadorLog manejadorLog = new ManejadorLog();
        try {
            emf.close();
            manejadorLog.debug("cerrarManager OK");
        } catch (Exception e) {
            manejadorLog.debug("##### error instanciarManager :" + e.getMessage());

        }
    }

    public Boolean actualiza(T entity) {
        Boolean bExito = true;
        ManejadorLog manejadorLog = new ManejadorLog();
        instanciarManager();
        EntityManager em = this.getEntityManager();
        try {
            manejadorLog.debug("Actualizando entity:" + entity);
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            manejadorLog.debug("fin merge");
            bExito = true;
        } catch (Exception e) {
            bExito = false;
            em.getTransaction().rollback();
            manejadorLog.debug("rollback_ " + e.toString());
        } finally {
            em.close();
            this.cerrarManager();
        }

        return bExito;
    }

    public Boolean actualizaEnTran(T entity) {
        Boolean bExito = true;
        ManejadorLog manejadorLog = new ManejadorLog();

        try {
            manejadorLog.debug("entity:" + entity);

            em.merge(entity);

            manejadorLog.debug("fin merge");
            bExito = true;
        } catch (Exception e) {
            bExito = false;

            manejadorLog.debug("rollback");
        } finally {
            manejadorLog.debug("Termina actualizaEnTran");
        }

        return bExito;
    }

    public Boolean elimina(T entity) {
        Boolean bExito = true;
        ManejadorLog manejadorLog = new ManejadorLog();
        instanciarManager();
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
            bExito = true;
        } catch (Exception e) {
            bExito = false;
            em.getTransaction().rollback();
            manejadorLog.debug("rollback_ " + e.toString());
        } finally {
            em.close();
            this.cerrarManager();
        }

        return bExito;
    }

    public T consulta(Object id) {
        this.instanciarManager();

        T entidadT = getEntityManager().find(this.getEntidad(), id);
        this.cerrarManager();
        return entidadT;
    }

    public T consultaEnTransaccion(Object id) {

        T entidadT = getEntityManager().find(this.getEntidad(), id);

        return entidadT;
    }

    public List<T> consultaTodo() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidad));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> consultaRango(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidad));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int cuenta() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entidad);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
