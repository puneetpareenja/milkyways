package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/signup")
    public ModelAndView addCustomer(Customer customer, HttpSession session) {
        ModelAndView modelAndView;
        if (customer.getEmail() == null) {
            System.out.println("customer info not provided");
            modelAndView = new ModelAndView("signup.html");
        } else {
            System.out.println("Saving customer with information \n" + customer);
            customerRepository.save(customer);
            customer = customerRepository.findByEmail(customer.getEmail());

            Customer sessionCustomer = (Customer) session.getAttribute("customer");
            if (sessionCustomer != null) {
                customer.setCart(sessionCustomer.getCart());
            }

            System.out.println("Customer Saved. Redirecting to home.");
            session.setAttribute("customer", customer);
            modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("customer", customer);
        }
        return modelAndView;
    }

    @RequestMapping("/signin")
    public ModelAndView redirectToSignIn(
            @RequestParam(name = "email", defaultValue = "") String email,
            @RequestParam(name = "password", defaultValue = "") String password,
            HttpSession session) {
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
                Customer sessionCustomer = (Customer) session.getAttribute("customer");
                if (sessionCustomer != null) {
                    customer.setCart(sessionCustomer.getCart());
                }
                session.setAttribute("customer", customer);
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
