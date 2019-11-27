package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Contact;
import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.entities.Item;
import com.runtimeterror.milkyways.entities.Sales;
import com.runtimeterror.milkyways.repositories.ContactRepository;
import com.runtimeterror.milkyways.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class RoutingController {

    @Autowired
    SalesRepository salesRepository;

    @GetMapping("/about")
    public ModelAndView redirectToAbout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("about.html");
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            customer = new Customer();
            session.setAttribute("customer", customer);
        }
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


    @GetMapping("/thankyou")
    public ModelAndView redirectToThankyou(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        Sales sales = new Sales();
        sales.setCustomer(customer);
        sales.setDate(new Date());
        sales.setItemlist(customer.getCart());
        double total = 0;
        for (Item item : customer.getCart()) {
            total += item.getPrice() * item.getQuantity();
        }
        sales.setTotal(total);
        salesRepository.save(sales);
        customer.setCart(new ArrayList<>());
        session.setAttribute("customer", customer);
        ModelAndView modelAndView = new ModelAndView("thankyou.html");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/contact")
    public ModelAndView redirectToContact(Contact contact, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("contact.html");
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            customer = new Customer();
            session.setAttribute("customer", customer);
        }
        if (contact.getEmail() == null) {
            System.out.println("customer info not provided");
        } else {
            System.out.println("Saving customer with information \n" + contact);
            contactRepository.save(contact);
        }
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView redirectToError() {
        ModelAndView modelAndView = new ModelAndView("error.html");

        return modelAndView;
    }

}
