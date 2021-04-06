package business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.UserModel;
import data.UserDataManager;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(RegistrationManagerInterface.class)
@LocalBean
public class RegistrationManager implements RegistrationManagerInterface {
	
	@EJB
	UserDataManager DAO;
	
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
