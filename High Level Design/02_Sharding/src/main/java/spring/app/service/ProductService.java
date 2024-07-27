package spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.app.model.products.Product;
import spring.app.repository.products.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional(transactionManager = "productsTransactionManager")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(transactionManager = "productsTransactionManager")
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional(transactionManager = "productsTransactionManager")
    public Product saveProduct(Product product) {
        Long productId = product.getId();
        if (productId != null) {
            Optional<Product> productInDb = productRepository.findById(productId);
            if (productInDb.isPresent()) {
                product = updateProduct(productInDb.get(), product);
            }
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product oldProduct, Product newProduct){
        if(newProduct.getDescription() != null) {
            oldProduct.setDescription(newProduct.getDescription());
        }
        if(newProduct.getName() != null) {
            oldProduct.setName(newProduct.getName());
        }
        if(newProduct.getPrice() != null) {
            oldProduct.setPrice(newProduct.getPrice());
        }

        return oldProduct;
    }

    @Transactional(transactionManager = "productsTransactionManager")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
