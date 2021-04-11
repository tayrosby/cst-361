package business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.Credentials;
import beans.UserModel;
import data.UserDataManager;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(LoginManagerInterface.class)
@LocalBean
public class LoginManager implements LoginManagerInterface {
	
	@EJB
	UserDataManager DAO;
	
	/**
	 * constructor
	 */
	public LoginManager() {
		
	}

	/**
	 * passes email and password to data service
	 * returns user info
	 */
	@Override
//	public UserModel loginUser(Credentials creds) {
//		UserModel user = DAO.findUserByCreds(creds);
//		
//		return user;
//	}
	public boolean loginUser(UserModel user) {
		if(DAO.findUserByCreds(user.getCreds()))
			return true;
		else
			return false;
	}
}
