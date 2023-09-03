package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.model.ShippingAddress;
import com.nocountry.ecommerce.repository.ShippingAddressRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressIMPL implements ShippingAddressService {
    
    @Autowired
    private ShippingAddressRepo shippingRepo;

    @Override
    public List<ShippingAddress> shippingAddressList() {
        
        return (List<ShippingAddress>) this.shippingRepo.findAll();
    }

    @Override
    public ShippingAddress createShippingAddress(ShippingAddress shippingAddress) {
        
         shippingAddress.setCity(shippingAddress.getCity());
         
         return this.shippingRepo.save(shippingAddress);
    }

    @Override
    public ShippingAddress modifyShippingAddress(ShippingAddress shippingAddress) {
        
        return this.shippingRepo.save(shippingAddress);
    }

    @Override
    public ShippingAddress consultShippingAddress(int id) {
        
        return this.shippingRepo.findById(id).get();
    }

    @Override
    public void deleteShippingAddress(int id) {
        
        this.shippingRepo.deleteById(id);
    }
    
}
