package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Contact;
import com.runtimeterror.milkyways.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoutingController {

    @GetMapping("/about")
    public ModelAndView redirectToAbout() {
        ModelAndView modelAndView = new ModelAndView("about.html");
        return modelAndView;
    }


    @GetMapping("/thankyou")
    public ModelAndView redirectToThankyou() {
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
