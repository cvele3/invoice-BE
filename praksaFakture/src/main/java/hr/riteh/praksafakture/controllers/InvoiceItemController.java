package hr.riteh.praksafakture.controllers;

import hr.riteh.praksafakture.constants.ControllerConstants;
import hr.riteh.praksafakture.constants.PathParamConstants;
import hr.riteh.praksafakture.database.entity.InvoiceItemEntity;
import hr.riteh.praksafakture.services.InvoiceItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(ControllerConstants.INVOICE_ITEM)
public class InvoiceItemController {

    private final InvoiceItemService invoiceItemService;

    @Autowired
    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @GetMapping(value = PathParamConstants.GET_ALL_INVOICE_ITEMS_FROM_INVOICE_ID + "/{id}")
    public ResponseEntity<List<InvoiceItemEntity>> getAllInvoiceItemsFromInvoiceId(@PathVariable Long id) {
        log.info("Getting all invoice items");
        List<InvoiceItemEntity> invoiceItemEntityList = invoiceItemService.getAllInvoiceItemsFromInvoiceId(id);

        return new ResponseEntity<>(invoiceItemEntityList, HttpStatus.OK);
    }

    @GetMapping(value = PathParamConstants.GET_INVOICE_ITEM_BY_ID + "/{id}")
    public ResponseEntity<InvoiceItemEntity> getInvoiceItemById(@PathVariable Long id) {
        log.info("Getting invoice item by id");
        InvoiceItemEntity invoiceItemEntity = invoiceItemService.getInvoiceItem(id);

        return new ResponseEntity<>(invoiceItemEntity, HttpStatus.OK);
    }
}