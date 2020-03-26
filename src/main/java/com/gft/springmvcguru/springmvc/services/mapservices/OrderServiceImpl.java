package com.gft.springmvcguru.springmvc.services.mapservices;


import com.gft.springmvcguru.springmvc.domain.DomainObject;
import com.gft.springmvcguru.springmvc.domain.Order;
import com.gft.springmvcguru.springmvc.domain.Product;
import com.gft.springmvcguru.springmvc.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class OrderServiceImpl extends AbstractMapService implements OrderService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Order getById(Integer id) {
        return (Order) super.getById(id);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        return (Order) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
