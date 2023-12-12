package soa.dao;


import soa.entities.Devise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class DeviseDaoImpl implements IDeviseDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Devise save(Devise devise) {
        em.persist(devise);
        return devise;
    }

    @Override
    public List findAll() {
        Query query = em.createQuery("select d from Devise d order by d.nomDevise");
        return query.getResultList();
    }

    @Override
    public Devise findOne(Long id) {
        return em.find(Devise.class, id);
    }

    @Override
    public Devise update(Devise devise) {
        em.merge(devise);
        return devise;
    }

    @Override
    public void delete(Long id) {
        Devise devise = em.find(Devise.class, id);
        em.remove(devise);
    }

    @Override
    public List findByNomDevise(String nomDevise) {
        Query query = em.createQuery("select d from Devise d where d.nomDevise like :x");
        query.setParameter("x", "%" + nomDevise + "%");
        return query.getResultList();
    }

    @Override
    public List findByTauxEchangeGreaterThan(double tauxEchangeMin) {
        Query query = em.createQuery("select d from Devise d where d.tauxEchange > :y");
        query.setParameter("y", tauxEchangeMin);
        return query.getResultList();
    }
}
