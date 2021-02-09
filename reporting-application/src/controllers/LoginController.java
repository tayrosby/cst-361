package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Credentials;
import beans.UserModel;
import business.LoginManager;

@ManagedBean
@ViewScoped
public class LoginController {

	//instance of login manager
	LoginManager manager = new LoginManager();
	
	/**
	 * takes in creds
	 * @param creds - user email and user password
	 * @return - Main Page
	 */
	public String login(Credentials creds) {
		
		UserModel user = manager.loginUser(creds);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "MainMenu.xhtml";
	}
	
	/**
	 * navigation
	 * @return - LoginPage
	 */
	public String moveTo() {
		return "LoginForm.xhtml";
	}
	
}
