package spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.app.model.products.Product;
import spring.app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/id")
    public Product getProductById(@RequestParam("productId") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam("productId") Long id) {
        productService.deleteProduct(id);
    }
}
