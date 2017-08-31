package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Add User");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {

        if(user.getPassword() != null && user.getPassword().equals(verify)) {
            model.addAttribute("name", user.getUserName());
            model.addAttribute("title", "Welcome");
            return "user/index";
        }
        model.addAttribute("title", "Error");
        model.addAttribute("username", user.getUserName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("error", "Passwords do not match");
        return "user/add";

    }


}
