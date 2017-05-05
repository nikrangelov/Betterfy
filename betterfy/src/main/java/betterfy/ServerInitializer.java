package betterfy;

import betterfy.entities.Role;
import betterfy.entities.User;
import betterfy.services.RoleService;
import betterfy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by nik on 5/5/17.
 */

@Component
public class ServerInitializer implements ApplicationRunner {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        // Add user role if does not exist.
        Role role = roleService.findByRole("ROLE_USER");

        if(role == null) {
            Role userRole = new Role();
            userRole.setRole("ROLE_USER");
            roleService.save(userRole);
        }

        User user = userService.findUserByEmail("user@betterfy.com");

        if(user == null){
            User defaultUser = new User();
            defaultUser.setEmail("user@betterfy.com");
            defaultUser.setPassword("1234");
            //userService.saveUser(defaultUser);
            //some problem occurs here
        }


    }
}
