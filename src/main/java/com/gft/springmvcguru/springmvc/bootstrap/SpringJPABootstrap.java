package com.gft.springmvcguru.springmvc.bootstrap;

import com.gft.springmvcguru.springmvc.domain.*;
import com.gft.springmvcguru.springmvc.enums.OrderStatus;
import com.gft.springmvcguru.springmvc.services.CustomerService;
import com.gft.springmvcguru.springmvc.services.ProductService;
import com.gft.springmvcguru.springmvc.services.UserService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    //    private ProductService productService;
//    private CustomerService customerService;
    private ProductService productService;
    private UserService userService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //    @Autowired
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadUsersAndCustomers();
        loadCarts();
        loadOrderHistory();
    }

    private void loadOrderHistory() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            Order order = new Order();
            order.setCustomer(user.getCustomer());
            order.setOrderStatus(OrderStatus.SHIPPED);

            products.forEach(product -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(1);
                order.addToOrderDetails(orderDetail);
            });
        });

    }


    private void loadCarts() {

        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            user.setCart(new Cart());
            CartDetail cartDetail = new CartDetail();
            cartDetail.setProduct(products.get(0));
            cartDetail.setQuantity(2);
            user.getCart().addCartDetail(cartDetail);
            userService.saveOrUpdate(user);
        });

    }


    public void loadProducts() {
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }

//    public void loadCustomers() {
////        Customer customer1 = new Customer();
////        customer1.setFirstName("Micheal");
////        customer1.setLastName("Weston");
////        customer1.setAddressLine1("1 Main St");
////        customer1.setCity("Miami");
////        customer1.setState("Florida");
////        customer1.setZipCode("33101");
////        customer1.setEmail("micheal@burnnotice.com");
////        customer1.setPhoneNumber("305.333.0101");
////        customerService.saveOrUpdate(customer1);
////
////        Customer customer2 = new Customer();
////        customer2.setFirstName("Fiona");
////        customer2.setLastName("Glenanne");
////        customer2.setAddressLine1("1 Key Biscane Ave");
////        customer2.setCity("Miami");
////        customer2.setState("Florida");
////        customer2.setZipCode("33101");
////        customer2.setEmail("fiona@burnnotice.com");
////        customer2.setPhoneNumber("305.323.0233");
////        customerService.saveOrUpdate(customer2);
////
////        Customer customer3 = new Customer();
////        customer3.setFirstName("Sam");
////        customer3.setLastName("Axe");
////        customer3.setAddressLine1("1 Little Cuba Road");
////        customer3.setCity("Miami");
////        customer3.setState("Florida");
////        customer3.setZipCode("33101");
////        customer3.setEmail("sam@burnnotice.com");
////        customer3.setPhoneNumber("305.426.9832");
////        customerService.saveOrUpdate(customer3);
//
//        Customer customer1 = new Customer();
//        customer1.setFirstName("Micheal");
//        customer1.setLastName("Weston");
//        customer1.setBillingAddress(new Address());
//        customer1.getBillingAddress().setAddressLine1("1 Main St");
//        customer1.getBillingAddress().setCity("Miami");
//        customer1.getBillingAddress().setState("Florida");
//        customer1.getBillingAddress().setZipCode("33101");
//        customer1.setEmail("micheal@burnnotice.com");
//        customer1.setPhoneNumber("305.333.0101");
//        customerService.saveOrUpdate(customer1);
//
//        Customer customer2 = new Customer();
//        customer2.setFirstName("Fiona");
//        customer2.setLastName("Glenanne");
//        customer2.setBillingAddress(new Address());
//        customer2.getBillingAddress().setAddressLine1("1 Key Biscane Ave");
//        customer2.getBillingAddress().setCity("Miami");
//        customer2.getBillingAddress().setState("Florida");
//        customer2.getBillingAddress().setZipCode("33101");
//        customer2.setEmail("fiona@burnnotice.com");
//        customer2.setPhoneNumber("305.323.0233");
//        customerService.saveOrUpdate(customer2);
//
//        Customer customer3 = new Customer();
//        customer3.setFirstName("Sam");
//        customer3.setLastName("Axe");
//        customer3.setBillingAddress(new Address());
//        customer3.getBillingAddress().setAddressLine1("1 Little Cuba Road");
//        customer3.getBillingAddress().setCity("Miami");
//        customer3.getBillingAddress().setState("Florida");
//        customer3.getBillingAddress().setZipCode("33101");
//        customer3.setEmail("sam@burnnotice.com");
//        customer3.setPhoneNumber("305.426.9832");
//        customerService.saveOrUpdate(customer3);
//
//    }
//}

    public void loadUsersAndCustomers() {
        User user1 = new User();
        user1.setUsername("mweston");
        user1.setPassword("password");

        Customer customer1 = new Customer();
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLine1("1 Main St");
        customer1.getBillingAddress().setCity("Miami");
        customer1.getBillingAddress().setState("Florida");
        customer1.getBillingAddress().setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");
        user1.setCustomer(customer1);
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("fglenanne");
        user2.setPassword("password");

        Customer customer2 = new Customer();
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setBillingAddress(new Address());
        customer2.getBillingAddress().setAddressLine1("1 Key Biscane Ave");
        customer2.getBillingAddress().setCity("Miami");
        customer2.getBillingAddress().setState("Florida");
        customer2.getBillingAddress().setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhoneNumber("305.323.0233");
        user2.setCustomer(customer2);
        userService.saveOrUpdate(user2);

        User user3 = new User();
        user3.setUsername("saxe");
        user3.setPassword("password");
        Customer customer3 = new Customer();
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setBillingAddress(new Address());
        customer3.getBillingAddress().setAddressLine1("1 Little Cuba Road");
        customer3.getBillingAddress().setCity("Miami");
        customer3.getBillingAddress().setState("Florida");
        customer3.getBillingAddress().setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");

        user3.setCustomer(customer3);
        userService.saveOrUpdate(user3);
    }
}

