package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.dto.PaymentTypeEntityDto;
import hr.riteh.praksafakture.database.entity.PaymentTypeEntity;

import java.util.List;

public interface PaymentTypeService {

    boolean isPaymentTypeValid(Long paymentTypeId);
    PaymentTypeEntity getPaymentType(Long paymentTypeId);
    PaymentTypeEntity createPaymentType(PaymentTypeEntity paymentTypeEntity);
    List<PaymentTypeEntity> getAllPaymentTypes();
    void deletePaymentType(Long paymentTypeId);
    PaymentTypeEntity updatePaymentType(PaymentTypeEntityDto paymentTypeEntityDto);
}
