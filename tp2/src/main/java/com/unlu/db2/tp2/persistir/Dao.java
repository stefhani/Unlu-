package com.unlu.db2.tp2.persistir;

import com.unlu.db2.tp2.entity.Cliente;
import com.unlu.db2.tp2.entity.Factura;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class Dao {

    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JPAPU");
    EntityManager em = emf.createEntityManager();

    /////////////////////////////////////////////////// CRUD //////////////////////////////////////////////////////
    public void persist(Object object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteFacturaXNro(Long nro) {
        try {
            Factura fac = em.find(Factura.class,nro);
            em.getTransaction().begin();
            em.remove(fac);
            em.getTransaction().commit();
            System.out.println("Factura Eliminada");
        } catch (Exception e) {
            System.out.println("Error Delete Factura: "+e.getMessage());
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteClienteXId(Long id) {
        try {
            Cliente cli = em.find(Cliente.class,id);
            em.getTransaction().begin();
            em.remove(cli);
            em.getTransaction().commit();
            System.out.println("Cliente Eliminada");
        } catch (Exception e) {
            System.out.println("Error Delete Cliente: "+e.getMessage());
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void updateClienteXId(Long id, String descr){
        try{
            Cliente cliu1 = em.find(Cliente.class,id);
            cliu1.setName(descr);
            em.getTransaction().begin();
            em.merge(cliu1);
            em.getTransaction().commit();
            System.out.println("Se realizo actualizacion");
        }catch(Exception e) {
            System.out.println("Error Update Cliente: "+e.getMessage());
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }
    //////////////////////////////////////////////////// Consultas ///////////////////////////////////////////////


    public List<Cliente> listarClientes() {
        Query qry = em.createNamedQuery("Clientetodos");
        return qry.getResultList();
    }

    public List<Factura> listarFacturas() {
        Query qry = em.createNamedQuery("Facturatodos");
        return qry.getResultList();
    }
    public List<Factura> listarFacturasXImporte(double importe) {
        Query qry = em.createNamedQuery("Facturaimporte");
        qry.setParameter("importe", importe);
        return qry.getResultList();
    }

    public List<Cliente> listarClienteXDescr(String descr) {
        Query query = em.createNamedQuery("ClienteXDescr");
        //Query query = em.createQuery("select c from Cliente c where c.descr LIKE ?1");
        query.setParameter(1, descr);
        return query.getResultList();
    }
    public List<Cliente> listarClientePorId(int id) {
        Query query = em.createNamedQuery("Clienteporid");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Factura> listarFacturasXId(int nro) {
        Query qry = em.createNamedQuery("Facturaxnro");
        qry.setParameter("nro", nro);
        return qry.getResultList();
    }

}
