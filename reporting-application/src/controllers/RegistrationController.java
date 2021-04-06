package controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped ;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import beans.UserModel;
import business.RegistrationManagerInterface;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class) 
@Named
@ViewScoped
public class RegistrationController implements Serializable {
	
	@EJB
	RegistrationManagerInterface manager;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * registers a user
	 * @param user - first name, last name, email, password
	 * @return main menu
	 */
	public String register(UserModel user) {
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "MainMenu.xhtml";

	}
	
	/**
	 * navigation
	 * @return - registration page
	 */
	public String moveTo() {
		return "RegistrationForm.xhtml";
	}
}
