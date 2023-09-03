package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.model.PaymentMethod;
import com.nocountry.ecommerce.service.PaymentMethodIMPL;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PaymentMethod")
public class PaymentMethodController {

    @Autowired
    PaymentMethodIMPL pmimpl;

    @GetMapping
    @RequestMapping(value = "paymentMethodList", method = RequestMethod.GET)
    public ResponseEntity<?> paymentMethodList() {

        List<PaymentMethod> list = this.pmimpl.paymentMethodList();

        return ResponseEntity.ok(list);

    }

    @PostMapping
    @RequestMapping(value = "createPaymentMethod", method = RequestMethod.POST)
    public ResponseEntity<?> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        
        if(paymentMethod.getCardType() == null || 
           paymentMethod.getCardType().isEmpty() ||
           paymentMethod.getCardType().isBlank())
           return new ResponseEntity<>("Card type can't be empty", HttpStatus.BAD_REQUEST );
        
        if(!paymentMethod.getCardType().matches("^[a-zA-Z]+$"))
            return new ResponseEntity<>("Card type must contain only letters", HttpStatus.NOT_ACCEPTABLE);
        
        if(paymentMethod.getCardNumber() == null || 
           paymentMethod.getCardNumber().isEmpty() || 
           paymentMethod.getCardNumber().isBlank())
           return new ResponseEntity<>("Card number can't be empty", HttpStatus.BAD_REQUEST);
        
        if((paymentMethod.getCardNumber().length()<15 || 
            paymentMethod.getCardNumber().length()>16))
            return new ResponseEntity<>("Please enter a valid number card", HttpStatus.NOT_ACCEPTABLE);
        
        if(!paymentMethod.getCardNumber().matches("\\d+"))
            return new ResponseEntity<>("Card Number must contain only digits", HttpStatus.BAD_REQUEST);
        
        if(paymentMethod.getSecurityCode() == null ||
           paymentMethod.getSecurityCode().isEmpty() ||
           paymentMethod.getSecurityCode().isBlank())
           return new ResponseEntity<>("Security code can't be empty", HttpStatus.BAD_REQUEST);
        
        if(!paymentMethod.getSecurityCode().matches("\\d+"))
            return new ResponseEntity<>("Security code must contain only digits", HttpStatus.NOT_ACCEPTABLE);
        
        if((paymentMethod.getSecurityCode().length()<3 || 
           paymentMethod.getSecurityCode().length()>4))
           return new ResponseEntity<>("Please enter a valid security code", HttpStatus.BAD_REQUEST);
        
        if(paymentMethod.getExpirationDate() == null || 
           paymentMethod.getExpirationDate().isEmpty() ||
           paymentMethod.getExpirationDate().isBlank())
           return new ResponseEntity<>("Expiration date can't be empty", HttpStatus.BAD_REQUEST);
        
        if(!paymentMethod.getExpirationDate().matches("^(0[1-9]|1[0-2])/(\\d{2}|\\d{4})$")) 
            return new ResponseEntity<>("Invalid expiration date format", HttpStatus.BAD_REQUEST);
        
        char x = paymentMethod.getExpirationDate().charAt(0);
        char z = paymentMethod.getExpirationDate().charAt(1);
        
        if (x < 0 && z > 9) return new ResponseEntity<>("Please enter a valid month", HttpStatus.NOT_ACCEPTABLE);

        if (x > 9 && z < 0) return new ResponseEntity<>("Please enter a valid month", HttpStatus.NOT_ACCEPTABLE);
        
        String [] parts = paymentMethod.getExpirationDate().split("/");
        
        int year = Integer.parseInt(parts[1]);
        int currentYear = LocalDate.now().getYear();
        
        if (year > currentYear + 7 || year < currentYear) return new ResponseEntity<>("Please enter a valid expiration date", HttpStatus.NOT_ACCEPTABLE);
        
        if(paymentMethod.getBillingAddress() == null ||
           paymentMethod.getBillingAddress().isEmpty() ||
           paymentMethod.getBillingAddress().isBlank())
           return new ResponseEntity<>("Billing address can't be empty", HttpStatus.BAD_REQUEST);
        
        PaymentMethod payment = this.pmimpl.createPaymentMethod(paymentMethod);

        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    @PutMapping
    @RequestMapping(value = "modifyPaymentMethod", method = RequestMethod.PUT)
    public ResponseEntity<?> modifyPaymentMethod(@RequestBody PaymentMethod paymentMethod) {

        if(paymentMethod.getCardType() == null || 
           paymentMethod.getCardType().isEmpty() ||
           paymentMethod.getCardType().isBlank())
           return new ResponseEntity<>("Card type can't be empty", HttpStatus.BAD_REQUEST );
        
        if(!paymentMethod.getCardType().matches("^[a-zA-Z]+$"))
            return new ResponseEntity<>("Card type must contain only letters", HttpStatus.NOT_ACCEPTABLE);
        
        if(paymentMethod.getCardNumber() == null || 
           paymentMethod.getCardNumber().isEmpty() || 
           paymentMethod.getCardNumber().isBlank())
           return new ResponseEntity<>("Card number can't be empty", HttpStatus.BAD_REQUEST);
        
        if((paymentMethod.getCardNumber().length()<15 || 
            paymentMethod.getCardNumber().length()>16))
            return new ResponseEntity<>("Please enter a valid number card", HttpStatus.NOT_ACCEPTABLE);
        
        if(!paymentMethod.getCardNumber().matches("\\d+"))
            return new ResponseEntity<>("Card Number must contain only digits", HttpStatus.BAD_REQUEST);
        
        if(paymentMethod.getSecurityCode() == null ||
           paymentMethod.getSecurityCode().isEmpty() ||
           paymentMethod.getSecurityCode().isBlank())
           return new ResponseEntity<>("Security code can't be empty", HttpStatus.BAD_REQUEST);
        
        if(!paymentMethod.getSecurityCode().matches("\\d+"))
            return new ResponseEntity<>("Security code must contain only digits", HttpStatus.NOT_ACCEPTABLE);
        
        if((paymentMethod.getSecurityCode().length()<3 || 
           paymentMethod.getSecurityCode().length()>4))
           return new ResponseEntity<>("Please enter a valid security code", HttpStatus.BAD_REQUEST);
        
        if(paymentMethod.getExpirationDate() == null || 
           paymentMethod.getExpirationDate().isEmpty() ||
           paymentMethod.getExpirationDate().isBlank())
           return new ResponseEntity<>("Expiration date can't be empty", HttpStatus.BAD_REQUEST);
        
        if(!paymentMethod.getExpirationDate().matches("^(0[1-9]|1[0-2])/(\\d{2}|\\d{4})$")) 
            return new ResponseEntity<>("Invalid expiration date format", HttpStatus.BAD_REQUEST);
        
        char x = paymentMethod.getExpirationDate().charAt(0);
        char z = paymentMethod.getExpirationDate().charAt(1);
        
        if (x < 0 && z > 9) return new ResponseEntity<>("Please enter a valid month", HttpStatus.NOT_ACCEPTABLE);

        if (x > 9 && z < 0) return new ResponseEntity<>("Please enter a valid month", HttpStatus.NOT_ACCEPTABLE);
        
        String [] parts = paymentMethod.getExpirationDate().split("/");
        
        int year = Integer.parseInt(parts[1]);
        int currentYear = LocalDate.now().getYear();
        
        if (year > currentYear + 7 || year < currentYear) return new ResponseEntity<>("Please enter a valid expiration date", HttpStatus.NOT_ACCEPTABLE);
        
        if(paymentMethod.getBillingAddress() == null ||
           paymentMethod.getBillingAddress().isEmpty() ||
           paymentMethod.getBillingAddress().isBlank())
           return new ResponseEntity<>("Billing address can't be empty", HttpStatus.BAD_REQUEST);
        
        PaymentMethod Payment = this.pmimpl.modifyPaymentMethod(paymentMethod);

        return ResponseEntity.status(HttpStatus.CREATED).body(Payment);
    }

    @GetMapping
    @RequestMapping(value = "consultPaymentMethod/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultPaymentMethod(@PathVariable int id) {

        PaymentMethod payment = null;
                
        payment = this.pmimpl.consultPaymentMethod(id);
        try{
            if(payment != null ) return new ResponseEntity<>(payment, HttpStatus.OK);
            
            else return new ResponseEntity<>("The given payment method doesn't exists", HttpStatus.NOT_FOUND);
            
        } catch (NoSuchElementException e) {
            e.printStackTrace(System.out);
            return new ResponseEntity<>("An error occurred while fetching the payment method", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping
    @RequestMapping(value = "deletePaymentMethod/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePaymentMethod(@PathVariable int id) {

        PaymentMethod payment = null;
        
        try {
        payment = this.pmimpl.consultPaymentMethod(id);
        if(payment != null) this.pmimpl.deletePaymentMethod(id);
        
        } catch(NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity<>("The given payment method doesn't exits", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}