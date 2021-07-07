package com.sg.FoodDelivery.controller;

import com.sg.FoodDelivery.dao.ClientDao;
import com.sg.FoodDelivery.model.Client;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.OrderItem;
import com.sg.FoodDelivery.service.Service;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    Service service;
    ClientDao clientDao;

    public ClientController(Service service, ClientDao clientDao) {
        this.service = service;
        this.clientDao = clientDao;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public int registerClient(@RequestBody Client client) {
        try{
            return clientDao.addClient(client);
        }
        catch(DuplicateKeyException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public int loginDriver(@RequestBody Client client){
        try{
            Client clientFromDB = clientDao.getClientByUsername(client.getUsername());
            if(service.checkPassword(client.getPassword(), clientFromDB.getPassword())){
                return clientFromDB.getId();
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid password/username");
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No user found with given username");
        }

    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public List<Order> getOrders(@RequestParam int clientId){

        return clientDao.viewOrders(clientId);
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public List<OrderItem> getOrderDetails(@RequestParam int orderId){

        return clientDao.viewOrderItems(orderId);
    }
}
