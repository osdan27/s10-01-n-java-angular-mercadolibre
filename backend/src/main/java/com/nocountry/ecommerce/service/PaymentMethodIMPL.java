package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.PaymentMethod;
import com.nocountry.ecommerce.repository.PaymentMethodRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodIMPL implements PaymentMethodService {

    @Autowired
    PaymentMethodRepo paymentRepo;

    @Override
    public List<PaymentMethod> paymentMethodList() {
        return (List<PaymentMethod>) this.paymentRepo.findAll();
    }

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethod.setID(paymentMethod.getID());
        return this.paymentRepo.save(paymentMethod);
    }

    @Override
    public PaymentMethod modifyPaymentMethod(PaymentMethod paymentMethod) {
        return this.paymentRepo.save(paymentMethod);
    }

    @Override
    public PaymentMethod consultPaymentMethod(int id) {
        return this.paymentRepo.findById(id).get();
    }

    @Override
    public void deletePaymentMethod(int id) {
        this.paymentRepo.deleteById(id);
    }
}
