package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/signup")
    public ModelAndView addCustomer(Customer customer) {
        ModelAndView modelAndView;
        if (customer.getEmail() == null) {
            System.out.println("customer info not provided");
            modelAndView = new ModelAndView("signup.html");
        } else {
            System.out.println("Saving customer with information \n" + customer);
            customerRepository.save(customer);
            System.out.println("Customer Saved. Redirecting to home.");
            modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("customer", customer);
        }
        return modelAndView;
    }

    @GetMapping("/signin")
    public ModelAndView redirectToSignIn(
            @RequestParam(name = "email", defaultValue = "") String email,
            @RequestParam(name = "password", defaultValue = "") String password) {
        ModelAndView modelAndView;

        System.out.println("email " + email);
        System.out.println("password " + password);

        if (email.equals("") && password.equals("")) {
            System.out.println("Credentials not provided");
            modelAndView = new ModelAndView("signin.html");
            modelAndView.addObject("errorMessage", "");

        } else {
            if (validateUser(email, password)) {
                System.out.println("Login Successful");
                modelAndView = new ModelAndView("redirect:/");
                Customer customer = customerRepository.findByEmail(email);
                modelAndView.addObject("customer", customer);
            } else {
                System.out.println("Login Failed");
                modelAndView = new ModelAndView("signin.html");
                modelAndView.addObject("errorMessage", "Invalid Username or password");
            }
        }
        return modelAndView;
    }

    private boolean validateUser(String email, String password) {
        System.out.println("Validation user");
        System.out.println("Getting customer by email " + email);
        Customer customer = customerRepository.findByEmail(email);
        try {
            System.out.println("Customer returned \n" + customer);
            return password.equals(customer.getPassword());
        } catch (Exception e) {
            System.out.println("Exception Caught");
            System.out.println(e.getMessage());
            return false;
        }
    }


}
