package data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import java.sql.Statement;
import java.util.ArrayList;
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
public class WeatherDataManager implements DataAccessInterface{
	/**
	 * findallweather method used to get all the weatherdatamodels in the database
	 * @return a list of weatherdatamodels is return
	 */
	public List<WeatherDataModel> findAllWeather(){
		/**
		 * the list of weather models
		 */
		List<WeatherDataModel> weatherlist = new ArrayList<WeatherDataModel>();
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:8889/mydb";
		String username = "root";
		String password = "root";

		try {

			// connect to database
			conn = DriverManager.getConnection(url, username, password);

			// the sql query to get all weatherdatamodels from the database
			String sql = String.format("SELECT * FROM `iot`");

			
			Statement stmt = conn.createStatement();

		
			ResultSet rs = stmt.executeQuery(sql);

			// populate list with values
			
			while (rs.next()) {
				weatherlist.add(new WeatherDataModel(rs.getFloat("TEMP"), rs.getFloat("FEELS_LIKE"), rs.getFloat("TEMP_MIN"), rs.getFloat("TEMP_MAX"), rs.getFloat("PRESSURE"),rs.getFloat("HUMIDITY")));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("There is an error in the database");
				}
			}
				
		}
	
		return weatherlist;
	}
	@Override
	public int create(WeatherDataModel weather) {

		int result = 0;
		System.out.println("In the create weather data service");
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:8889/mydb";
		String username = "root";
		String password = "root";

		try {

			// connect to database
			conn = DriverManager.getConnection(url, username, password);
			
			//sql query to add a weatherdata model from the iot device
			String sql = "INSERT INTO `iot`(`TEMP`, `FEELS_LIKE`, `TEMP_MIN`, `TEMP_MAX`, `PRESSURE`, `HUMIDITY`) VALUES ('" + weather.getTemp() + 
					"','" + weather.getFeels_like() + "','" + weather.getTemp_min() + "','" + weather.getTemp_max() + "','" + weather.getPressure() + "','" + weather.getHumidity() + "')"; 
			
			Statement stmt = conn.createStatement();

			// get a result
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("There is an error in the database");
				}
			}
				
		}
		
		return result;

	}

	@Override
	public boolean findUserByCreds(Credentials creds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
