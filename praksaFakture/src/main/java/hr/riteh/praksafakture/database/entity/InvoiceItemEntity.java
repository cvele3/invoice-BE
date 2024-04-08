package hr.riteh.praksafakture.database.entity;

import hr.riteh.praksafakture.constants.ColumnNames;
import hr.riteh.praksafakture.constants.TableNames;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = TableNames.INVOICE_ITEMS)
public class InvoiceItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID, nullable = false)
    private Long id;

    @Basic
    @Column(name = ColumnNames.QUANTITY, nullable = false)
    private Long quantity;

    @Basic
    @Column(name = ColumnNames.AMOUNT, nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = ColumnNames.INVOICE_ID, referencedColumnName = ColumnNames.ID)
    private InvoiceEntity invoice;

    @ManyToOne
    @JoinColumn(name = ColumnNames.PRODUCT_ID, referencedColumnName = ColumnNames.ID)
    private ProductEntity product;

    @Override
    public String toString() {
        return "InvoiceItemEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", invoice=" + invoice +
                ", product=" + product +
                '}';
    }
}
