package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;

@Controller
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/signUp")
    public ModelAndView addCustomer(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("testpage.html");
        try {
            customerRepository.save(customer);
            modelAndView.addObject("customer", customer);
        } catch (ConstraintViolationException ex) {

        } finally {
            return modelAndView;
        }
    }
}
