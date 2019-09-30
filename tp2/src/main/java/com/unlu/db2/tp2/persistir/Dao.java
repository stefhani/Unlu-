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

    public List<Cliente> listarClientes() {
        Query qry = em.createNamedQuery("Clientetodos");
        return qry.getResultList();
    }

    public List<Factura> listarFacturas() {
        Query qry = em.createNamedQuery("Facturatodos");

        return qry.getResultList();
    }
}
