package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.PaymentMethod;
import java.util.List;

public interface PaymentMethodService {

    List<PaymentMethod> paymentMethodList();

    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod modifyPaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod consultPaymentMethod(int id);

    void deletePaymentMethod(int id);

}
