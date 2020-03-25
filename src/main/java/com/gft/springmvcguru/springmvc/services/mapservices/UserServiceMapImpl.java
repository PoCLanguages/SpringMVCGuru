package com.gft.springmvcguru.springmvc.services.mapservices;

import com.gft.springmvcguru.springmvc.domain.DomainObject;
import com.gft.springmvcguru.springmvc.domain.User;
import com.gft.springmvcguru.springmvc.services.UserService;

import java.util.List;

/**
 * Created by jt on 12/14/15.
 */
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}