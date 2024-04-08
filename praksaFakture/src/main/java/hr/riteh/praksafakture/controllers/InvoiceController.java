package hr.riteh.praksafakture.controllers;

import hr.riteh.praksafakture.constants.ControllerConstants;
import hr.riteh.praksafakture.constants.PathParamConstants;
import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import hr.riteh.praksafakture.managers.InvoiceManager;
import hr.riteh.praksafakture.requests.CreateInvoiceRequest;
import hr.riteh.praksafakture.services.InvoiceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(ControllerConstants.INVOICE)
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceManager invoiceManager;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, InvoiceManager invoiceManager) {
        this.invoiceService = invoiceService;
        this.invoiceManager = invoiceManager;
    }

    @GetMapping(PathParamConstants.GET_ALL_INVOICES)
    public ResponseEntity<List<InvoiceEntity>> getAllInvoices() {
        log.info("Getting all invoices");
        List<InvoiceEntity> invoiceEntityList = invoiceService.getAllInvoices();

        return new ResponseEntity<>(invoiceEntityList, HttpStatus.OK);
    }

    @GetMapping(PathParamConstants.GET_INVOICE_BY_ID + "/{id}")
    public ResponseEntity<InvoiceEntity> getInvoiceById(@PathVariable Long id) {
        log.info("Getting invoice by id");
        InvoiceEntity invoiceEntity = invoiceService.getInvoiceById(id);

        return new ResponseEntity<>(invoiceEntity, HttpStatus.OK);
    }

    @PostMapping(value = PathParamConstants.CREATE_INVOICE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceEntity> createInvoice(@RequestBody CreateInvoiceRequest createInvoiceRequest) {
        log.info("Creating invoice");
        InvoiceEntity createdInvoiceEntity = invoiceManager.createInvoice(createInvoiceRequest);

        return new ResponseEntity<>(createdInvoiceEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = PathParamConstants.DELETE_INVOICE + "/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        log.info("Deleting invoice");
        invoiceManager.deleteInvoice(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}