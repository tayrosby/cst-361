package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.UserModel;
import data.UserDataManager;

@Stateless
@Local(RegistrationManagerInterface.class)
@LocalBean
public class RegistrationManager implements RegistrationManagerInterface {

	//instance of data manager
UserDataManager DAO = new UserDataManager();
	
	/**
	 * constructor
	 */
    public RegistrationManager() {

    }

	/**
	 * registers a user
	 * return - currently returns true as a default
     */
    public boolean register(UserModel user) {
    	
    	DAO.createUser(user);
    	
    	return true;
    }
}
