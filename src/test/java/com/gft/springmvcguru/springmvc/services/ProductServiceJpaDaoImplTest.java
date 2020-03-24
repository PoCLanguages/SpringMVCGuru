package com.gft.springmvcguru.springmvc.services;

import com.gft.springmvcguru.springmvc.config.JpaIntegrationConfig;
import com.gft.springmvcguru.springmvc.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception{
        List<Product> products = (List<Product>) productService.listAll();

        assert products.size() == 5;
    }


}


//Okay, your turn to write some code.
//
//        Complete the following tasks:
//
//        Write additional integration tests to complete coverage for the ProductServiceJpaDao implementation.
//        Create a JPA DAO implementation for the Customer class.
//        Add bootstrap data for Customers.
//        Refactor Product and Customer map services to use bootstrap class to load data.
//        Write Integration tests for Customer JPA DAO.