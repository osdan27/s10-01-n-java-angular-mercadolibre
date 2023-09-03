package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.model.Client;
import com.nocountry.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    ClientService clientService;


    @GetMapping
    public ResponseEntity<List<Client>> getCLients(){

        List<Client> listaClientes = clientService.getClients();
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }

    /*@PostMapping
    public ResponseEntity<Object> createClient(@RequestBody Client client){
        return this.clientService.newClient(client);
    }

    @PutMapping(value= "/{id}")
    public String updateClient(@PathVariable long id, @RequestBody Client client){
        return this.clientService.updateClient(id, client);
    }

    @DeleteMapping(value= "/{id}")
    public String deleteClient(@PathVariable long id){
        return this.clientService.deleteClient(id);
    } */
}
