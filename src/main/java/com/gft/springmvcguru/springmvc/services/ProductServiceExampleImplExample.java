package com.gft.springmvcguru.springmvc.services;

import com.gft.springmvcguru.springmvc.domain.ProductExample;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceExampleImplExample implements ProductServiceExample {

    private Map<Integer, ProductExample> products;

    public ProductServiceExampleImplExample() {
        loadProducts();
    }

    @Override
    public List<ProductExample> listAllProducts() {
        return new ArrayList<>(products.values());
    }


    @Override
    public ProductExample getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    @Override
    public ProductExample saveOrUpdateProduct(ProductExample product) {
        if (products != null) {
            if(product.getId() == null){
                product.setId(getNextKey());
            }

            products.put(product.getId(), product);

            return product;
        }else{
            throw new RuntimeException("Product can't be nill");
        }
    }

    private Integer getNextKey() {
        return Collections.max(products.keySet()) + 1;
    }

    private void loadProducts() {
        products = new HashMap<>();

        ProductExample product1 = new ProductExample();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        products.put(1, product1);

        ProductExample product2 = new ProductExample();
        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        products.put(2, product2);

        ProductExample product3 = new ProductExample();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        products.put(3, product3);

        ProductExample product4 = new ProductExample();
        product4.setId(4);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        products.put(4, product4);

        ProductExample product5 = new ProductExample();
        product5.setId(5);
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        products.put(5, product5);
    }
}
