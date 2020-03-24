package com.gft.springmvcguru.springmvc.controllers;


import org.springframework.stereotype.Controller;

@Controller
public class ProductControllerExample {

//    private ProductServiceExample productService;
//
//    @Autowired
//    public void setProductService(ProductServiceExample productServiceExample) {
//        this.productService = productServiceExample;
//    }
//
//    @RequestMapping("/products")
//    public String listProducts(Model model){
//
//        model.addAttribute("products", productService.listAllProducts());
//
//        return "products";
//    }
//
//    @RequestMapping("/product/{id}")
//    public String getProduct(@PathVariable Integer id, Model model){
//        model.addAttribute("product", productService.getProductById(id));
//        return "product";
//    }
//
//    @RequestMapping("product/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model){
//        model.addAttribute("product", productService.getProductById(id));
//        return "productform";
//    }
//
//    @RequestMapping("/product/new")
//    public String newProduct(Model model){
//        model.addAttribute("product", new Product());
//        return "productform";
//    }
//
//    @RequestMapping(value = "/product", method = RequestMethod.POST)
//    public String saveOrUpdateProduct(Product product){
//        Product savedProduct = productService.saveOrUpdateProduct(product);
//        return "redirect:/product/" + savedProduct.getId();
//    }
//
//    @RequestMapping("/product/delete/{id}")
//    public String delete(@PathVariable Integer id){
//        productService.deleteProduct(id);
//        return "redirect:/products";
//    }

}
