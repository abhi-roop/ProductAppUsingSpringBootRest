package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.val;

@NoArgsConstructor
@RestController
@RequestMapping("/products") // http://localhost:1909/products
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/getMsg") // http://localhost:1909/products/getMsg
    public String sayHello() {
        return "am trying to listen but am getting sleep";
    }

    @PostMapping("/saveproduct") // http://localhost:1909/products/saveproduct
    public String insertProduct(@RequestBody @Validated Product product) {
        return service.saveProduct(product);
    }

    @PutMapping("/updateproduct") // http://localhost:1909/products/updateproduct
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @GetMapping("/getproduct/{pid}") // http://localhost:1909/products/getproduct/{pid}
    public Product getProductById(@PathVariable("pid") int productId) throws ProductNotFound {
        return service.getProduct(productId);
    }

    @DeleteMapping("/deleteproduct/{pid}") // http://localhost:1909/products/deleteproduct/{pid}
    public String deleteProduct(@PathVariable("pid") int productId) {
        return service.removeProduct(productId);
    }

    @GetMapping("/getallproducts") // http://localhost:1909/products/getallproducts
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/getproductsbycategory/{category}") // http://localhost:1909/products/getproductsbycategory/{category}
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return service.getAllProductsByCategory(category);
    }

    @GetMapping("/getproductsbetween/{initialPrice}/{finalPrice}") // http://localhost:1909/products/getproductsbetween/{initialPrice}/{finalPrice}
    public List<Product> getProductsBetween(@PathVariable("initialPrice") int initialPrice, @PathVariable("finalPrice") int finalPrice) {
        return service.getAllProductsBetween(initialPrice, finalPrice);
    }

    @GetMapping("/getproductsabove/{price}") // http://localhost:1909/products/getproductsabove/{price}
    public List<Product> getProductsAbove(@PathVariable("price") int price) {
        return service.getAllProductsAbovePrice(price);
    }
}
