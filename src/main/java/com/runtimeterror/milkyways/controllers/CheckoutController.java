package com.runtimeterror.milkyways.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public ModelAndView redirectToCheckout() {
        ModelAndView modelAndView = new ModelAndView("checkout.html");

        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView redirectToCart() {
        ModelAndView modelAndView = new ModelAndView("cart.html");

        return modelAndView;
    }
}
