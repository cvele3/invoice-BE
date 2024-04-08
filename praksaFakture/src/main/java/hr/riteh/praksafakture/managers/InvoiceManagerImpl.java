package hr.riteh.praksafakture.managers;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import hr.riteh.praksafakture.database.entity.InvoiceItemEntity;
import hr.riteh.praksafakture.requests.CreateInvoiceRequest;
import hr.riteh.praksafakture.services.InvoiceItemService;
import hr.riteh.praksafakture.services.InvoiceService;
import hr.riteh.praksafakture.services.PaymentTypeService;
import hr.riteh.praksafakture.services.ProductService;
import hr.riteh.praksafakture.utils.MathUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class InvoiceManagerImpl implements InvoiceManager {

    private final InvoiceService invoiceService;
    private final ProductService productService;
    private final PaymentTypeService paymentTypeService;
    private final InvoiceItemService invoiceItemService;

    @Autowired
    public InvoiceManagerImpl(InvoiceService invoiceService, ProductService productService, PaymentTypeService paymentTypeService, InvoiceItemService invoiceItemService) {
        this.invoiceService = invoiceService;
        this.productService = productService;
        this.paymentTypeService = paymentTypeService;
        this.invoiceItemService = invoiceItemService;
    }

    @Override
    public InvoiceEntity createInvoice(CreateInvoiceRequest request) {
        log.info("1. Creating invoice");

        if (!paymentTypeService.isPaymentTypeValid(request.getPaymentTypeId())) {
            throw new IllegalArgumentException("Payment type is not valid");
        }

        log.info("2. Creating invoice entity");
        InvoiceEntity invoiceEntity = new InvoiceEntity();

        log.info("3. Setting invoice entity properties");
        invoiceEntity.setPaymentType(paymentTypeService.getPaymentType(request.getPaymentTypeId()));
        invoiceEntity.setInvoiceDate(new Date());
        invoiceEntity.setInvoiceAmount(MathUtils.roundToTwoDecimalPlaces(productService.getTotalProductsPrice(request.getProducts())));
        invoiceEntity.setCustomerName(request.getCustomerName());
        invoiceEntity.setInvoiceNumber(invoiceService.getInvoiceNumber());

        log.info("4. Saving invoice entity");
        InvoiceEntity savedInvoiceEntity = invoiceService.createInvoice(invoiceEntity);

        log.info("5. Creating invoice items");
        for (var entry : request.getProducts().entrySet()) {
            InvoiceItemEntity invoiceItemEntity = new InvoiceItemEntity();
            invoiceItemEntity.setInvoice(savedInvoiceEntity);
            invoiceItemEntity.setProduct(productService.getProduct(entry.getKey()));
            invoiceItemEntity.setQuantity(entry.getValue());
            invoiceItemEntity.setAmount(MathUtils.roundToTwoDecimalPlaces(productService.getSumProductPrice(entry.getKey(), entry.getValue())));
            invoiceItemService.createInvoiceItem(invoiceItemEntity);
        }

        return savedInvoiceEntity;
    }

    @Override
    public void deleteInvoice(Long id) {
        log.info("1. Deleting invoice items for invoice with id: {}", id);
        invoiceItemService.deleteInvoiceItemsByInvoiceId(id);

        log.info("2. Deleting invoice with id: {}", id);
        invoiceService.deleteInvoice(id);
    }
}
