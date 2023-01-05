
package com.myproyects.demo.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproyects.demo.entidades.Conductor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ConductorDaoImpl implements ConductorDao {
        
        @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Conductor> findAll() {
        return em.createQuery("from Conductor").getResultList();
    }

    @Transactional(readOnly = false)
    @Override
    public void registrar(Conductor conductor) {
        if ( conductor.getDni() > 0) {
            em.merge(conductor);
        } else {
            em.persist(conductor);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Conductor findOne(Integer dni) {
        return em.find(Conductor.class, dni);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Integer dni) {
        em.remove(findOne(dni));
    }
}

