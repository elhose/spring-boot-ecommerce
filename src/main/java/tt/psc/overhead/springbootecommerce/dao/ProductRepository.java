package tt.psc.overhead.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tt.psc.overhead.springbootecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
