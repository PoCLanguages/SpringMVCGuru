package com.gft.springmvcguru.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }

}

//
//Check out the tests, see if any are failing and fix them.
//Modify Cart Detail to include a quantity property.
//Add Date Created, Date Updated to User, Product, Cart, Cart Line. Hint: Perhaps Hibernate can maintain these values for us automatically.
//Create an Order Entity. The Order Entity should have a Customer and a shipping address.
//Use a Java Enum for Order status: NEW, ALLOCATED, SHIPPED
//Add Date Created, Date Updated, and Date Shipped to Order.
//Create an Order Line Entity. The Order Line belongs to the Order Entity. Support multiple Order Lines to an Order. The Order line should have Product, and quantity ordered.
//Create an Order Service which can do CRUD operations on Orders, and cascade operations to Order Lines.
//Update Bootstrap service to populate user information for customers.
//Update Bootstrap class to populate a cart record for each user, and order history for each user, each product.