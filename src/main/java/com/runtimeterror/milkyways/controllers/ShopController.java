package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Item;
import com.runtimeterror.milkyways.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/shop")
    public ModelAndView redirectToShop() {
        ModelAndView modelAndView = new ModelAndView("shop.html");
        List<Item> itemlist = (List<Item>) itemRepository.findAll();
        modelAndView.addObject("items", itemlist);
        return modelAndView;
    }

    @GetMapping("/shop-single")
    public ModelAndView redirectToShopSingle(@RequestParam(defaultValue = "0") long id) {
        ModelAndView modelAndView = new ModelAndView("shop-single.html");
        Item item = itemRepository.findById(id).orElse(new Item());
        if (item.getItemid() == 0) {
            return redirectToShop();
        }
        modelAndView.addObject(item);
        return modelAndView;
    }

    @RequestMapping("/search")
    public ModelAndView searchItem(@RequestParam(defaultValue = "") String text) {
        System.out.println(text);

        ModelAndView modelAndView = new ModelAndView("shop.html");
        List<Item> itemlist = itemRepository.findAllByNameContainingIgnoreCase(text);
        modelAndView.addObject("items", itemlist);
        return modelAndView;
    }
}
