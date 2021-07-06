package com.sg.FoodDelivery.controller;

import com.sg.FoodDelivery.dao.DriverDao;
import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Rating;
import com.sg.FoodDelivery.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    Service service;
    DriverDao dao;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public int registerDriver(@RequestBody Driver driver){
        try{
            return dao.addDriver(driver);
        }
        catch(DuplicateKeyException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
    }

    @GetMapping("/login")
    public String displayLogin(){
        return "driverLogin";
    }

    @PostMapping("/validateLogin")
    public String loginDriver(HttpServletRequest request){

        Driver driver = new Driver(request.getParameter("username"),
                                    request.getParameter("password"));

        try{
            Driver driverFromDB = dao.getDriverByUsername(driver.getUsername());
            if(service.checkPassword(driver.getPassword(), driverFromDB.getPassword())){
                return "redirect:/driverLogin";
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid password/username");
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No user found with given username");
        }
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> getAvailableOrders(){
        return dao.viewAvailableOrders();
    }

    @PutMapping("/{driverId}/acceptorder")
    @ResponseStatus(HttpStatus.CREATED)
    public void acceptOrder(@PathVariable int driverId, @RequestBody int orderId){
        dao.acceptOrder(driverId, orderId);
    }

    @GetMapping("/{driverId}/orders")
    @ResponseBody
    public List<Order> getDriverOrders(@PathVariable int driverId){
        return dao.viewCompletedOrders(driverId);
    }

    @PostMapping("/rateclient")
    public void rateClient(@RequestBody Rating rating){
        dao.rateClient(rating);
    }


    public DriverController(DriverDao dao, Service service){
        this.dao = dao;
        this.service = service;
    }

}
