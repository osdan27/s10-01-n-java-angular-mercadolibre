package com.nocountry.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorColumn(name="entity", discriminatorType= DiscriminatorType.STRING)
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @Column(name = "client_uuid")
    private long clientUuid;
    private String name;
    @Column(name = "email", nullable = false,unique = true)
    @Email(message = "Please enter a valid email!")
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    private String address;
    private String contactDetalls;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private RolTipe rol;

}


enum RolTipe{
    ADMIN,
    USER
}