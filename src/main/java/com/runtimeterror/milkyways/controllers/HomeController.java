package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = {"", "/", "/home", "welcome"})
    public ModelAndView initHome(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");

        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
