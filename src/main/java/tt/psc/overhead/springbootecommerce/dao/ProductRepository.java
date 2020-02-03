package tt.psc.overhead.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tt.psc.overhead.springbootecommerce.entity.Product;

//@Repository
@CrossOrigin("http://localhost:4200") //so this repo can access this site
public interface ProductRepository extends JpaRepository<Product, Long> {
}
