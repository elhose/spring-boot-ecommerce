package tt.psc.overhead.springbootecommerce.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    @ManyToOne(targetEntity = ProductCategory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = ProductNames.CATEGORY_ID, nullable = false)
    private ProductCategory category;

    @Column(name = ProductNames.SKU)
    private String sku;

    @Column(name = ProductNames.NAME)
    private String name;

    @Column(name = ProductNames.DESCRIPTION)
    private String description;

    @Column(name = ProductNames.UNIT_PRICE)
    private BigDecimal unitPrice;

    @Column(name = ProductNames.IMAGE_URL)
    private String imageUrl;

    @Column(name = ProductNames.ACTIVE)
    private Boolean active;

    @Column(name = ProductNames.UNITS_IN_STOCK)
    private Integer unitsInStock;

    @Column(name = ProductNames.DATE_CREATED)
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = ProductNames.LAST_UPDATED)
    @UpdateTimestamp
    private Date dateUpdated;

}
