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
@Table(name = TableNames.PRODUCTS)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID, nullable = false)
    private Long id;

    @Basic
    @Column(name = ColumnNames.NAME, nullable = false, length = 100)
    private String name;

    @Basic
    @Column(name = ColumnNames.DESCRIPTION)
    private String description;

    @Basic
    @Column(name = ColumnNames.PRICE, nullable = false)
    private Double price;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}