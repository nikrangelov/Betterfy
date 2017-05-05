package betterfy.controllers;

import betterfy.entities.User;
import betterfy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "public/register",  method = RequestMethod.POST)
    public String register(WebRequest request, Model model){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null) {
            model.addAttribute("failure", true);
            return "register";
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(password);
        userService.saveUser(user);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(username, password));

        return "redirect:/home";
    }



}
