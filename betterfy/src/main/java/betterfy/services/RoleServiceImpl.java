package betterfy.services;

import betterfy.entities.Role;
import betterfy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    public Role findByRole(String role){
        return roleRepository.findByRole(role);
    }

    public void save(Role role){
        roleRepository.save(role);
    }
}
