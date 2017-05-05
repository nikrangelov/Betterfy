package betterfy.controllers;


import betterfy.entities.Greeting;
import betterfy.entities.Role;
import betterfy.entities.User;
import betterfy.repositories.RoleRepository;
import betterfy.services.UserService;
import betterfy.services.UserServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "public/data",  method = RequestMethod.GET)
    public String getPublicData(){
        return "Public data!";
    }

    @RequestMapping(value = "private/data",  method = RequestMethod.GET)
    public String getPrivateData(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return "Private data! " + name;
    }


    @RequestMapping(value = "public/createUser",  method = RequestMethod.GET)
    public String createUser(){
        //Role role = new Role();
        //role.setRole("ROLE_USER");
        //roleRepository.save(role);

        User user = new User();
        user.setEmail("nik@nik.com");
        user.setPassword("qaz20");
        userService.saveUser(user);
        return "User created!";
    }

    @RequestMapping(value = "private/greeting", method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(){
        return new Greeting(1, "Hello stranger");

    }

    @RequestMapping(value = "public/getUser",  method = RequestMethod.GET)
    public ResponseEntity<User> getUser(){
        User user = userService.findUserByEmail("nik@nik.com");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
