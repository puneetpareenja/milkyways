package com.runtimeterror.milkyways.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoutingController {

    @GetMapping("/checkout")
    public ModelAndView redirectToCheckout() {
        ModelAndView modelAndView = new ModelAndView("checkout.html");

        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView redirectToAbout() {
        ModelAndView modelAndView = new ModelAndView("about.html");

        return modelAndView;
    }

    @GetMapping("/shop")
    public ModelAndView redirectToShop() {
        ModelAndView modelAndView = new ModelAndView("shop.html");

        return modelAndView;
    }

    @GetMapping("/thankyou")
    public ModelAndView redirectToThankyou() {
        ModelAndView modelAndView = new ModelAndView("thankyou.html");

        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView redirectToContact() {
        ModelAndView modelAndView = new ModelAndView("contact.html");

        return modelAndView;
    }

    @GetMapping("/shop-single")
    public ModelAndView redirectToShopSingle() {
        ModelAndView modelAndView = new ModelAndView("shop-single.html");

        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView redirectToError() {
        ModelAndView modelAndView = new ModelAndView("error.html");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView redirectToHome() {
        ModelAndView modelAndView = new ModelAndView("index.html");

        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView redirectToCart() {
        ModelAndView modelAndView = new ModelAndView("cart.html");

        return modelAndView;
    }

}
