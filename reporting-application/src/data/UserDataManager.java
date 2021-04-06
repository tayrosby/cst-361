package data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;

import beans.Credentials;
import beans.UserModel;
import beans.WeatherDataModel;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class UserDataManager implements DataAccessInterface {
	
	/**
	 * constructor
	 */
	public UserDataManager() {
		
	}

	/**
	 * searches db for matching email and password
	 * returns the user model
	 */
	@Override
	public UserModel findUserByCreds(Credentials creds) {
		
		String email = creds.getEmail();
		String pword = creds.getPassword();
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:8080/weather-reporting";
		String username = "root";
		String password = "root";
		
		String sql = "SELECT * FROM `users` WHERE `email` = '" + email + "' AND `password` = '" + pword + "'";
		UserModel user = new UserModel();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conn = DriverManager.getConnection(url, username, password);
				} catch (SQLException s) {
					s.printStackTrace();
				}
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					user.setFirstName(rs.getString("firstName"));
					user.setLastName(rs.getString("lastName"));
					user.setCreds(new Credentials(rs.getString("email"), rs.getString("password")));
				}
				
				rs.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					
			}
			
			return user;
	}

	/**
	 * inserts a user into the db
	 * returns the user model
	 */
	@Override
	public UserModel createUser(UserModel user) {
		
		Credentials creds = user.getCreds();
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:8080/weather-reporting";
		String username = "root";
		String password = "root";
		
		String sql = "INSERT INTO `users` (`firstName`, `lastname`, `email`, `password`) VALUES ('" + user.getFirstName() + 
				"','" + user.getLastName() + "','" + creds.getEmail() + "','" + creds.getPassword() + "')";
	
		UserModel users = new UserModel();
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conn = DriverManager.getConnection(url, username, password);
					} catch (SQLException s) {
						
						s.printStackTrace();
					}
				
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if(conn != null) {
							try {
								conn.close();
							} catch (SQLException s) {
								s.printStackTrace();
							}
						}
					}
			return users;
			}

	@Override
	public int create(WeatherDataModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<WeatherDataModel> findAllWeather() {
		// TODO Auto-generated method stub
		return null;
	}

}
