package com.gft.springmvcguru.springmvc.services.jpaservices;

import com.gft.springmvcguru.springmvc.domain.security.Role;
import com.gft.springmvcguru.springmvc.services.RoleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jt on 12/18/15.
 */
@Service
@Profile("jpadao")
public class RoleServiceJpaImpl extends AbstractJpaDaoService implements RoleService {

    @Override
    public List<Role> listAll() {
        EntityManager em = emf.createEntityManager();
        List<Role> lista = em.createQuery("from Role", Role.class).getResultList();
        em.close();
        return lista;
    }

    @Override
    public Role getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Role role = em.find(Role.class, id);
        return role;
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Role saveRole = em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return saveRole;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Role.class, id));
        em.getTransaction().commit();
        em.close();
    }
}