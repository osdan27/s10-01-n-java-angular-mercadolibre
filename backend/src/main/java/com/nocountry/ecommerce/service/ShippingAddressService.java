package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.ShippingAddress;
import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddress> shippingAddressList();

    ShippingAddress createShippingAddress(ShippingAddress shippingAddress);

    ShippingAddress modifyShippingAddress(ShippingAddress shippingAddress);

    ShippingAddress consultShippingAddress(int id);

    void deleteShippingAddress(int id);

}
