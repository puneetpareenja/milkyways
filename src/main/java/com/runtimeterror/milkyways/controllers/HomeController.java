package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.entities.Item;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import com.runtimeterror.milkyways.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = {"", "/", "/home", "/welcome"})
    public ModelAndView initHome(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            customer = new Customer();
            session.setAttribute("customer", customer);
        }

        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("customer", customer);
        List<Item> sweetitems = itemRepository.findAllByTypeIs(true);
        List<Item> savouryitems = itemRepository.findAllByTypeIs(false);

        modelAndView.addObject("sweet", sweetitems);
        modelAndView.addObject("savoury", savouryitems);

        return modelAndView;
    }
}
