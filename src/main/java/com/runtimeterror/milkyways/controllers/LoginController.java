package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;

@Controller
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/signup")
    public ModelAndView addCustomer(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("signup.html");
        try {
            customerRepository.save(customer);
            modelAndView.addObject("customer", customer);
        } catch (ConstraintViolationException ignored) {

        } finally {
            return modelAndView;
        }
    }


    @GetMapping("/signin")
    public ModelAndView redirectToSignIn(
            @RequestParam(name = "email", defaultValue = "") String email,
            @RequestParam(name = "password", defaultValue = "") String password) {
        ModelAndView modelAndView = new ModelAndView("signin.html");

        if (!email.equals("") || !password.equals("")) {
            boolean isValid = validateUser(email, password);
            modelAndView.addObject("isvalid", isValid);
        }

        return modelAndView;
    }





    private boolean validateUser(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        return customer.getPassword().equals(password);
    }


}
