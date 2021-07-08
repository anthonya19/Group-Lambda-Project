package com.sg.FoodDelivery.controller;

import com.sg.FoodDelivery.dao.DriverDao;
import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.OrderDisplay;
import com.sg.FoodDelivery.model.Rating;
import com.sg.FoodDelivery.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    Service service;
    DriverDao dao;

    @PostMapping("/register")
    public String registerDriver(HttpServletRequest request, HttpSession session){

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        Driver driver = new Driver(username, password);

        try{
            session.setAttribute("driverId", dao.addDriver(driver));
            session.setAttribute("driverName", username);
            return "redirect:/driver/driverhomepage";
        }
        catch(DuplicateKeyException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
    }

    @PostMapping("/validateLogin")
    public String loginDriver(HttpServletRequest request, HttpSession session){

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        if(username.equals("") || password.equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username and password can not be empty");
        }

        Driver driver = new Driver(username, password);

        try{
            Driver driverFromDB = dao.getDriverByUsername(driver.getUsername());
            if(service.checkPassword(driver.getPassword(), driverFromDB.getPassword())){
                session.setAttribute("driverId", driverFromDB.getId());
                session.setAttribute("driverName", driverFromDB.getUsername());
                return "redirect:/driver/driverhomepage";
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid password/username");
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No user found with given username");
        }
    }

    @GetMapping("/driverhomepage")
    public String getAvailableOrders(Model model, HttpSession session){
        List<OrderDisplay> availableOrders = dao.getAvailableOrderDisplay();
        Integer driverId = (Integer)session.getAttribute("driverId");
        List<OrderDisplay> pastOrders = dao.getPastOrders(driverId.intValue());

        model.addAttribute("availableOrders", availableOrders);
        model.addAttribute("pastOrders", pastOrders);
        return "DriverHomePage";
    }

    @GetMapping("/acceptorder")
    public String acceptOrder(Integer orderId, HttpSession session){

        Integer driverId = (Integer)session.getAttribute("driverId");
        dao.acceptOrder(driverId.intValue(), orderId);
        return "redirect:/driver/driverhomepage";
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

    @GetMapping("/{driverId}/ratings")
    public List<Rating> viewRatings(@PathVariable int driverId){
        return dao.viewRatings(driverId);
    }

    public DriverController(DriverDao dao, Service service){
        this.dao = dao;
        this.service = service;
    }

}
