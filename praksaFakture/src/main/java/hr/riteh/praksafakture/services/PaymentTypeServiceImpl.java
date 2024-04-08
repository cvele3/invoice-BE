package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.dto.PaymentTypeEntityDto;
import hr.riteh.praksafakture.database.entity.PaymentTypeEntity;
import hr.riteh.praksafakture.database.mapper.PaymentTypeMapper;
import hr.riteh.praksafakture.database.repository.PaymentTypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{

    private final PaymentTypeRepository paymentTypeRepository;
    private final PaymentTypeMapper paymentTypeMapper;

    @Autowired
    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository, PaymentTypeMapper paymentTypeMapper) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.paymentTypeMapper = paymentTypeMapper;
    }

    @Override
    public boolean isPaymentTypeValid(Long paymentTypeId) {
        log.info("Checking if payment type with id: {} is valid", paymentTypeId);

        return paymentTypeRepository.findById(paymentTypeId).isPresent();
    }

    @Override
    public PaymentTypeEntity getPaymentType(Long paymentTypeId) {
        log.info("Getting payment type with id: {}", paymentTypeId);
        return paymentTypeRepository.findById(paymentTypeId)
            .orElseThrow(() -> new IllegalArgumentException("Payment type with id: " + paymentTypeId + " does not exist"));
    }

    @Override
    public PaymentTypeEntity createPaymentType(PaymentTypeEntity paymentTypeEntity) {
        log.info("Creating payment type");
        return paymentTypeRepository.save(paymentTypeEntity);
    }

    @Override
    public List<PaymentTypeEntity> getAllPaymentTypes() {
        log.info("Getting all payment types");
        return paymentTypeRepository.findAll();
    }

    @Override
    public void deletePaymentType(Long paymentTypeId) {
        log.info("Deleting payment type with id: {}", paymentTypeId);
        paymentTypeRepository.deleteById(paymentTypeId);
    }

    @Override
    public PaymentTypeEntity updatePaymentType(PaymentTypeEntityDto paymentTypeEntityDto) {
        log.info("Updating payment type with id: {}", paymentTypeEntityDto.getId());
        PaymentTypeEntity oldPaymentTypeEntity = paymentTypeRepository.findById(paymentTypeEntityDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("Payment type with id: " + paymentTypeEntityDto.getId() + " does not exist"));

        log.info("Old payment type: {}", oldPaymentTypeEntity.toString());
        PaymentTypeEntity updatedPaymentTypeEntity = paymentTypeMapper.update(oldPaymentTypeEntity, paymentTypeEntityDto);
        paymentTypeRepository.save(updatedPaymentTypeEntity);

        log.info("New payment type: {}", updatedPaymentTypeEntity.toString());
        return updatedPaymentTypeEntity;
    }
}
