package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Customer;
import com.runtimeterror.milkyways.entities.Item;
import com.runtimeterror.milkyways.repositories.CustomerRepository;
import com.runtimeterror.milkyways.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class CheckoutController {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/checkout")
    public ModelAndView redirectToCheckout() {
        ModelAndView modelAndView = new ModelAndView("checkout.html");
        return modelAndView;
    }


    @RequestMapping("/cart")
    public ModelAndView redirectToCart(
            HttpSession session, @RequestParam(defaultValue = "0") long id,
            @RequestParam(defaultValue = "0") int quantity) {
        ModelAndView modelAndView = new ModelAndView("cart.html");
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            customer = new Customer();
        }

        Item item;
        if (id != 0) {
            item = itemRepository.findById(id).orElse(new Item());
            item.setQuantity(quantity);
            customer.getCart().add(item);
            session.setAttribute("customer", customer);
        }

        double total = 0;
        for (Item cartItem : customer.getCart()) {
            total+= cartItem.getQuantity()*cartItem.getPrice();
        }

        modelAndView.addObject("cart", customer.getCart());
        modelAndView.addObject("total", total);
        return modelAndView;
    }
}
