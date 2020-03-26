package com.gft.springmvcguru.springmvc.services.jpaservices;

import com.gft.springmvcguru.springmvc.domain.Order;
import com.gft.springmvcguru.springmvc.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;


@Service
@Profile("jpadao")
public class OrderServiceJpaDaoImpl extends AbstractJpaDaoService implements OrderService {

    @Override
    public List<Order> listAll() {
        EntityManager em = emf.createEntityManager();
        List<Order> lista = em.createQuery("from Order", Order.class).getResultList();
        return lista;
    }

    @Override
    public Order getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, id);
        return order;
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Order savedOrder = em.merge(domainObject);
        em.getTransaction().commit();

        return savedOrder;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Order.class, id));
        em.getTransaction().commit();
    }
}
