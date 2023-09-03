package com.nocountry.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Data
@DiscriminatorValue("customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Customers extends Account implements Serializable {

    @Column(name = "number")
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "tipo_document")
    private String documentType;
    @Column(name = "number_document")
    private Long documentNumber;
    @Column(name = "state_membership")
    private String membershipState;


    public Customers(String email, String password){
        super(email,password);
    }

    public Customers(String email){
        super(email);
    }
}
