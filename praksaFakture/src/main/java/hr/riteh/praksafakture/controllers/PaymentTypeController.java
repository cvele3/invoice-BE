package hr.riteh.praksafakture.controllers;

import hr.riteh.praksafakture.constants.ControllerConstants;
import hr.riteh.praksafakture.constants.PathParamConstants;
import hr.riteh.praksafakture.database.dto.PaymentTypeEntityDto;
import hr.riteh.praksafakture.database.entity.PaymentTypeEntity;
import hr.riteh.praksafakture.services.PaymentTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(ControllerConstants.PAYMENT_TYPE)
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    @Autowired
    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping(PathParamConstants.GET_ALL_PAYMENT_TYPES)
    public ResponseEntity<List<PaymentTypeEntity>> getAllPaymentTypes() {
        log.info("Getting all payment types");
        List<PaymentTypeEntity> paymentTypeEntityList = paymentTypeService.getAllPaymentTypes();

        return new ResponseEntity<>(paymentTypeEntityList, HttpStatus.OK);
    }

    @GetMapping(PathParamConstants.GET_PAYMENT_TYPE_BY_ID + "/{id}")
    public ResponseEntity<PaymentTypeEntity> getPaymentTypeById(@PathVariable Long id) {
        log.info("Getting payment type by id");
        PaymentTypeEntity paymentTypeEntity = paymentTypeService.getPaymentType(id);

        return new ResponseEntity<>(paymentTypeEntity, HttpStatus.OK);
    }

    @PostMapping(value = PathParamConstants.CREATE_PAYMENT_TYPE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentTypeEntity> createPaymentType(@RequestBody PaymentTypeEntity paymentTypeEntity) {
        log.info("Creating payment type");
        PaymentTypeEntity createdPaymentTypeEntity = paymentTypeService.createPaymentType(paymentTypeEntity);

        return new ResponseEntity<>(createdPaymentTypeEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = PathParamConstants.DELETE_PAYMENT_TYPE + "/{id}")
    public ResponseEntity<Void> deletePaymentType(@PathVariable Long id) {
        log.info("Deleting payment type");
        paymentTypeService.deletePaymentType(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = PathParamConstants.UPDATE_PAYMENT_TYPE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentTypeEntity> updatePaymentType(@RequestBody PaymentTypeEntityDto paymentTypeEntityDto) {
        log.info("Updating payment type");
        PaymentTypeEntity updatedPaymentTypeEntity = paymentTypeService.updatePaymentType(paymentTypeEntityDto);

        return new ResponseEntity<>(updatedPaymentTypeEntity, HttpStatus.OK);
    }
}