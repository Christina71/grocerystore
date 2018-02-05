package com.example.grocerystore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
    @Autowired
    JBCStoreRepository jbcstoreRepository;

    @RequestMapping ("/")
    public String listJBCStore(Model model){
        model.addAttribute("jbcstores", jbcstoreRepository.findAll());
        return "jbcstoreform";

    }@GetMapping("/cosmetics")
    public String shopCosmetics(Model model){
        model.addAttribute("jbcstore", new JBCStore());
        return "cosmetics";

    }@GetMapping("/cleaning")
    public String shopCleaning(Model model){
        model.addAttribute("jbcstore", new JBCStore());
        return "cleaning";
    }@GetMapping("/snacks")
    public String shopSnacks(Model model){
        model.addAttribute("jbcstore", new JBCStore());
        return "snacks";
    }



}
