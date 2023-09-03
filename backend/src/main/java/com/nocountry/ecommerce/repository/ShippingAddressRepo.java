package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.model.ShippingAddress;
import org.springframework.data.repository.CrudRepository;

public interface ShippingAddressRepo extends CrudRepository<ShippingAddress, Integer> {

}
