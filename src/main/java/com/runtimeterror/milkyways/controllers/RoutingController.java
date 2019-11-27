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
    public ModelAndView redirectToAbout() {
        ModelAndView modelAndView = new ModelAndView("about.html");
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
        return modelAndView;
    }


    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/contact")
    public ModelAndView redirectToContact(Contact contact) {
        ModelAndView modelAndView = new ModelAndView("contact.html");
        if (contact.getEmail() == null) {
            System.out.println("customer info not provided");
            modelAndView = new ModelAndView("contact.html");
        } else {
            System.out.println("Saving customer with information \n" + contact);
            contactRepository.save(contact);
        }
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView redirectToError() {
        ModelAndView modelAndView = new ModelAndView("error.html");

        return modelAndView;
    }

}
