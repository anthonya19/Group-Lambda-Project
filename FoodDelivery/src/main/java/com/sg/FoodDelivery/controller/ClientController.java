package com.sg.FoodDelivery.controller;

import com.sg.FoodDelivery.dao.ClientDao;
import com.sg.FoodDelivery.dao.RestaurantDao;
import com.sg.FoodDelivery.model.*;
import com.sg.FoodDelivery.service.Service;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    Service service;
    ClientDao clientDao;
    RestaurantDao restaurantDao;

    public ClientController(Service service, ClientDao clientDao, RestaurantDao restaurantDao) {
        this.service = service;
        this.clientDao = clientDao;
        this.restaurantDao = restaurantDao;
    }

    @PostMapping("/register")
    public String registerClient(HttpServletRequest request, HttpSession session) {

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String address = request.getParameter("address");

        Client client = new Client(username, password, address);

        try{
            session.setAttribute("clientId", clientDao.addClient(client));
            session.setAttribute("clientName", username);
            session.setAttribute("clientAddress", address);
            return "redirect:/client/clienthomepage";
        }
        catch(DuplicateKeyException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
    }

    @PostMapping("/validateLogin")
    public String loginClient(HttpServletRequest request, HttpSession session){

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        Client client = new Client(username, password);

        try{
            Client clientFromDB = clientDao.getClientByUsername(client.getUsername());
            if(service.checkPassword(client.getPassword(), clientFromDB.getPassword())){
                session.setAttribute("clientId", clientFromDB.getId());
                session.setAttribute("clientName", clientFromDB.getUsername());
                session.setAttribute("clientAddress", clientFromDB.getAddress());
                return "redirect:/client/clienthomepage";
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid password/username");
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No user found with given username");
        }

    }

    @GetMapping("/clienthomepage")
    public String getAvailableOrders(Model model, HttpSession session){

        Integer clientId = (Integer)session.getAttribute("clientId");
        List<OrderDisplay> orders = clientDao.getOrderDisplay(clientId);

        model.addAttribute("orders", orders);
        return "ClientHomePage";
    }

    @GetMapping("/placeorder")
    public String placeOrder(Model model){
        List<Restaurant> restaurants = restaurantDao.getRestaurants();
        model.addAttribute("restaurants", restaurants);

        return "test";
    }

    @GetMapping("/confirmorder")
    public String addOrder(String restaurant, Integer menuItemId, HttpSession session){


        int itemId = menuItemId.intValue();
        Integer clientId = (Integer)session.getAttribute("clientId");

        clientDao.placeOrder(restaurant, itemId, clientId);

        return "redirect:/client/clienthomepage";
    }



    @GetMapping("/orders/{id}")
    @ResponseBody
    public List<Order> getOrders(@RequestParam int clientId){

        return clientDao.viewOrders(clientId);
    }

    @GetMapping("/orderitems/{id}")
    @ResponseBody
    public List<OrderItem> getOrderDetails(@RequestParam int orderId){

        return clientDao.viewOrderItems(orderId);
    }
}
