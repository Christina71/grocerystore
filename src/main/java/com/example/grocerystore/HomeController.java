package com.example.grocerystore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    JBCStoreRepository jbcstoreRepository;

    @RequestMapping ("/")
    public String listJBCStore(Model model){
        model.addAttribute("jbcstores", jbcstoreRepository.findAll());
        return "list";

    }@GetMapping("/add")
    public String jbcstoreForm(Model model){
        model.addAttribute("jbcstore", new JBCStore());
        return "jbcstoreform";
    }
    @PostMapping("/process")
    public String processForm(@Valid JBCStore jbcstore, BindingResult result)
    {
        if (result.hasErrors()){
            return "jbcstoreform";
        }

            jbcstoreRepository.save(jbcstore);
            return "redirect:/";
        }@RequestMapping("/detail/{id}")
            public String showJBCStore(@PathVariable("id") long id, Model model){
            model.addAttribute("jbcstore",jbcstoreRepository.findOne(id));
            return "show";
    }@RequestMapping("/update/{id}")
     public String updateJBCStore (@ PathVariable("id") long id, Model model){
        model.addAttribute("jbcstore", jbcstoreRepository.findOne(id));
        return "jbcstoreform";


    } @RequestMapping ("/delete/{id}")
    public String delJBCStore(@PathVariable("id") long id){
        jbcstoreRepository.delete(id);
        return "redirect:/";
    }

}
