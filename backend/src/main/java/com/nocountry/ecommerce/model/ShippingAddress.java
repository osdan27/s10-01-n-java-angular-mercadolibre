package com.nocountry.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "shipping_address")
public class ShippingAddress implements Serializable {
private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_ID")
    private int shippingID;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account", referencedColumnName = "account_uuid")
    private Account account;
}
