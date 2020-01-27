package tt.psc.overhead.springbootecommerce.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import tt.psc.overhead.springbootecommerce.entity.names.ProductNames;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = ProductNames.TABLENAME)
@Data
@NoArgsConstructor
public class Product {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ProductNames.ID)
    private Long id;

    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private Boolean active;
    private Integer unitsInStock;
    private Date dateCreated;
    private Date dateUpdated;
    private Integer categoryId;


    
}
