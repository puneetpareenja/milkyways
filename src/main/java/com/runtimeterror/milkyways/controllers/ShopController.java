package com.runtimeterror.milkyways.controllers;

import com.runtimeterror.milkyways.entities.Item;
import com.runtimeterror.milkyways.entities.Store;
import com.runtimeterror.milkyways.repositories.ItemRepository;
import com.runtimeterror.milkyways.repositories.StoreRepository;
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

    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/shop")
    public ModelAndView redirectToShop(
            @RequestParam(defaultValue = "false", required = false) boolean glutenfree,
            @RequestParam(defaultValue = "false", required = false) boolean sugarfree,
            @RequestParam(defaultValue = "false", required = false) boolean dairyfree,
            @RequestParam(defaultValue = "false", required = false) boolean vegetarian,
            @RequestParam(defaultValue = "-1", required = false) int type

    ) {

        ModelAndView modelAndView = new ModelAndView("shop.html");
        List<Item> itemlist;
        if (glutenfree) {
            itemlist = itemRepository.findAllByGlutenfreeIs(true);
        } else if (sugarfree) {
            itemlist = itemRepository.findAllBySugarfreeIs(true);
        } else if (dairyfree) {
            itemlist = itemRepository.findAllByDairyfreeIs(true);
        } else if (vegetarian) {
            itemlist = itemRepository.findAllByVegetarianIs(true);
        } else if (type == 1) {
            itemlist = itemRepository.findAllByTypeIs(true);
        } else if (type == 0) {
            itemlist = itemRepository.findAllByTypeIs(false);
        } else {
            itemlist = (List<Item>) itemRepository.findAll();
        }


        List<Store> storelist = (List<Store>) storeRepository.findAll();
        modelAndView.addObject("items", itemlist);
        modelAndView.addObject("stores", storelist);
        return modelAndView;
    }

    @GetMapping("/shop-single")
    public ModelAndView redirectToShopSingle(@RequestParam(defaultValue = "0") long id) {
        ModelAndView modelAndView = new ModelAndView("shop-single.html");
        Item item = itemRepository.findById(id).orElse(new Item());
        if (item.getItemid() == 0) {
            return new ModelAndView("redirect:/shop");
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
