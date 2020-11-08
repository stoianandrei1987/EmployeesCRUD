package ro.andreistoian.EmployeesCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.andreistoian.EmployeesCRUD.models.User;
import ro.andreistoian.EmployeesCRUD.services.UserService;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/")
    public String loadMain(Model model) {
        List<User> users = service.listAll();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit_user");
        mav.addObject("user", service.getUser(id));
        return mav;
    }

    @RequestMapping(value="/new")
    public ModelAndView newUser() {
        User user = new User();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("new_user");
        mav.getModel().put("user", user);
        return mav;
    }


    @RequestMapping(value="/new2")
    public String newUser2(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }


    @RequestMapping(value = "/save")
    public String saveUser(@ModelAttribute(name = "user") User user) {
        service.saveUser(user);
        return "redirect:/";
    }





}
