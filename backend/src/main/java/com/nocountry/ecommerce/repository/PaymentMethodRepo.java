package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.model.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

public interface PaymentMethodRepo extends CrudRepository<PaymentMethod, Integer> {

}
