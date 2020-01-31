package tt.psc.overhead.springbootecommerce.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tt.psc.overhead.springbootecommerce.entity.names.ProductCategoryNames;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = ProductCategoryNames.TABLENAME)
//@Data - known bug when using relationships
@Getter
@Setter
@NoArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ProductCategoryNames.ID)
    private Long id;

    @Column(name = ProductCategoryNames.CATEGORY_NAME)
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category" /*category - the name of field in Product.java*/)
    private Set<Product> products;
}
