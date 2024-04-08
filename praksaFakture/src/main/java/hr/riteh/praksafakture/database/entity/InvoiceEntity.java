package hr.riteh.praksafakture.database.entity;

import hr.riteh.praksafakture.constants.ColumnNames;
import hr.riteh.praksafakture.constants.TableNames;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = TableNames.INVOICES)
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID, nullable = false)
    private Long id;

    @Basic
    @Column(name = ColumnNames.INVOICE_DATE, nullable = false)
    private Date invoiceDate;

    @Basic
    @Column(name = ColumnNames.CUSTOMER_NAME, nullable = false, length = 100)
    private String customerName;

    @Basic
    @Column(name = ColumnNames.INVOICE_NUMBER, nullable = false)
    private Long invoiceNumber;

    @Basic
    @Column(name = ColumnNames.INVOICE_AMOUNT, nullable = false)
    private Double invoiceAmount;

    @ManyToOne
    @JoinColumn(name = ColumnNames.PAYMENT_TYPE, referencedColumnName = ColumnNames.ID)
    private PaymentTypeEntity paymentType;

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "InvoiceEntity{" +
                "id=" + id +
                ", invoiceDate=" + dateFormat.format(invoiceDate) +
                ", customerName='" + customerName + '\'' +
                ", invoiceNumber=" + invoiceNumber +
                ", invoiceAmount=" + invoiceAmount +
                ", paymentType=" + paymentType +
                '}';
    }
}