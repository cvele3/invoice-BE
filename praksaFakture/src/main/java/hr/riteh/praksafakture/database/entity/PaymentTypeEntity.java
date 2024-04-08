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
@Table(name = TableNames.PAYMENT_TYPES)
public class PaymentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID, nullable = false)
    private Long id;

    @Basic
    @Column(name = ColumnNames.TYPE, nullable = false, length = 50)
    private String type;

    @Override
    public String toString() {
        return "PaymentTypeEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}