package com.gft.springmvcguru.springmvc.services;

import com.gft.springmvcguru.springmvc.domain.ProductExample;

import java.util.List;

public interface ProductServiceExample {

    List<ProductExample> listAllProducts();

    ProductExample getProductById(Integer id);

    ProductExample saveOrUpdateProduct(ProductExample product);

    void deleteProduct(Integer id);
}
