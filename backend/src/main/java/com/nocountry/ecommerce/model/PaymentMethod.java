package com.nocountry.ecommerce.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "payment_method")
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_ID")
    private int ID;
    @Column(name = "card_type", nullable = false)
    private String cardType;
    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;
    @Column(name = "expiration_date", nullable = false)
    private String expirationDate;
    @Column(name = "security_code", nullable = false)
    private String securityCode;
    @Column(name = "billing_address", nullable = false)
    private String billingAddress;
    @ManyToOne
    @JoinColumn(name = "id_account", referencedColumnName = "account_uuid")
    private Account account;
}
