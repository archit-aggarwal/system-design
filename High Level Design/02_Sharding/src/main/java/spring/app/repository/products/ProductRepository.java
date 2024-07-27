package spring.app.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.model.products.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}