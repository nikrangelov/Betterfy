package betterfy.services;

import betterfy.entities.Role;
import org.springframework.stereotype.Component;

/**
 * Created by nik on 5/5/17.
 */

@Component
public interface RoleService {

    public Role findByRole(String role);

    void save(Role role);

}
