package betterfy.services;

import betterfy.entities.User;

public interface UserService {

    public User findUserByEmail(String email);
	public void saveUser(User user);

}