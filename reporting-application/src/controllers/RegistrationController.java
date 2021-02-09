package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.UserModel;
import business.RegistrationManager;

@ManagedBean
@ViewScoped
public class RegistrationController {

RegistrationManager manager = new RegistrationManager();
	
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
