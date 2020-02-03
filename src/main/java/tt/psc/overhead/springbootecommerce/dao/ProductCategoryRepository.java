package tt.psc.overhead.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import tt.psc.overhead.springbootecommerce.entity.ProductCategory;

@CrossOrigin("http://localhost:4200") //so this repo can access this site
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
