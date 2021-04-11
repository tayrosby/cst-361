package data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import util.DatabaseException;
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
	public boolean findUserByCreds(Credentials creds) {
		
		String email = creds.getEmail();
		String pword = creds.getPassword();
		Boolean result = false;
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:8889/mydb";
		String username = "root";
		String password = "root";
		
		String sql = "SELECT * FROM `user` WHERE `email` = ? AND `password` = ? ";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conn = DriverManager.getConnection(url, username, password);
				} catch (SQLException s) {
					s.printStackTrace();
					throw new DatabaseException(s);
				}
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setObject(1, creds.getEmail());
				ps.setObject(2, creds.getPassword());
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					result = true;
				}
				
				rs.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new DatabaseException(e);
			} finally {
				if(conn != null) {
					try {
						conn.close();
						return result;
					} catch (SQLException e) {
						e.printStackTrace();
						throw new DatabaseException(e);
					}
				}
					
			}
			
			return result;
	}

	/**
	 * inserts a user into the db
	 * returns the user model
	 */
	@Override
	public boolean createUser(UserModel user) {
		
		Credentials creds = user.getCreds();
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:8889/mydb";
		String username = "root";
		String password = "root";
		
		String sql = "INSERT INTO user (firstName, lastName, email, password) VALUES (?,?,?,?)";  
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conn = DriverManager.getConnection(url, username, password);
					} catch (SQLException s) {
						s.printStackTrace();
						throw new DatabaseException(s);
					}
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setObject(1, user.getFirstName());
					ps.setObject(2, user.getLastName());
					ps.setObject(3, user.getCreds().getEmail());
					ps.setObject(4, user.getCreds().getPassword());
					//Statement stmt = conn.createStatement();
					ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
						throw new DatabaseException(e);
					} finally {
						if(conn != null) {
							try {
								conn.close();
								return true;
							} catch (SQLException s) {
								s.printStackTrace();
								throw new DatabaseException(s);
							}
						}
					}
			return false;
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
