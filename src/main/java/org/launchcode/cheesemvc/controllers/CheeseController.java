package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseList;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseList.getCheeses());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }

        CheeseList.addCheese(newCheese);
        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseList.getCheeses());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] ids) {
        for (int cheeseId : ids) {
            CheeseList.remove(cheeseId);
        }
        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value= "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        model.addAttribute("cheese", CheeseList.getById(cheeseId));
        model.addAttribute("title", "Edit Cheese");
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(@PathVariable int cheeseId, String name, String description, CheeseType type) {
        Cheese theCheese = CheeseList.getById(cheeseId);
        theCheese.setName(name);
        theCheese.setDescription(description);
        theCheese.setType(type);

        return "redirect:/cheese";
    }

}
