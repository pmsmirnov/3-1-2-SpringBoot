package ru.pmsmirnov31.__Spring_boot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pmsmirnov31.__Spring_boot.model.User;
import ru.pmsmirnov31.__Spring_boot.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String usersPage(HttpServletRequest request, ModelMap model) {
        List<User> uList = userService.listUsers();
        if (request.getParameter("count") == null) {
            model.addAttribute("users___", uList);
            return "users";
        }
        int quantity = Integer.parseInt(request.getParameter("count"));
        List<User> outList = uList.stream().limit(quantity).toList();
        model.addAttribute("users___", outList);
        return "users";
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "add";
    }

    @PostMapping()
    public String add(@RequestParam("f_n") String fN, @RequestParam("l_n") String lN,
                      @RequestParam("e_m") String eM) {
        User newUser = new User();
        newUser.setFirstName(fN);
        newUser.setLastName(lN);
        newUser.seteMail(eM);
        userService.add(newUser);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit")
    public String editPage(@RequestParam(value = "userId") int uId, ModelMap model) {
        User user = userService.getUserById(uId);
        model.addAttribute("user_", user);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@RequestParam(value = "id_user") int idU, @RequestParam("f_n") String fN,
                       @RequestParam("l_n") String lN, @RequestParam("e_m") String eM) {
        User userForUpd = new User(fN, lN, eM);
        userService.update(userForUpd, idU);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete")
    public String editPage(@RequestParam(value = "userId") int uId) {
        userService.deleteUser(userService.getUserById(uId));
        return "redirect:/users";
    }

}
