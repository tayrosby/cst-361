package controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped ;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import beans.Credentials;
import beans.UserModel;
import business.LoginManagerInterface;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class) 
@Named
@ViewScoped
public class LoginController implements Serializable {
	
	@EJB
	LoginManagerInterface manager;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * takes in creds
	 * @param creds - user email and user password
	 * @return - Main Page
	 */
	public String login(UserModel user) {
		
		try {
			if(manager.loginUser(user)) {
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
				return "MainMenu.xhtml";
			}
			return "LoginForm.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception.xhtml";
		}

	}
	
	/**
	 * navigation
	 * @return - LoginPage
	 */
	public String moveTo() {
		return "LoginForm.xhtml";
	}
	
}
