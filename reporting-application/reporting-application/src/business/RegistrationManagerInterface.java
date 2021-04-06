package business;

import beans.UserModel;

public interface RegistrationManagerInterface {
	
	/**
	 * registers a new user
	 * @param user - first name, last name, email, password
	 * @return - true = user made, false = user not made
	 */
	boolean register(UserModel user);
}
