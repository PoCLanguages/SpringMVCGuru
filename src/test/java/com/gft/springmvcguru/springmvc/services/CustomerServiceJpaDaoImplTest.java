package com.gft.springmvcguru.springmvc.services;

import com.gft.springmvcguru.springmvc.config.JpaIntegrationConfig;
import com.gft.springmvcguru.springmvc.domain.Customer;
import com.gft.springmvcguru.springmvc.domain.Product;
import com.gft.springmvcguru.springmvc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testListMethod() throws Exception{
        List<Customer> customers = (List<Customer>) customerService.listAll();

        assert customers.size() == 3;
    }

    @Test
    public void testSaveWithUser(){
        Customer customer = new Customer();
        User user = new User();
        user.setUsername("This is my user name");
        user.setPassword("MyAwesomePassword");
        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);
        assert savedCustomer.getUser().getId() != null;
    }


}
