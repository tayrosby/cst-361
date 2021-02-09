import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Victoria Fai and Taylor Rosby
 *
 */
//Cst-361
//2/7/21
//WeatherModel class
//This class is the weathermodel used for the weather
@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherModel {
	/**
	 * Temp, feels_like, temp_min, temp_max, pressure, and humidity are components a part of the weather api 
	 */
	float temp;
	float feels_like;
	float temp_min;
	float temp_max;
	float pressure;
	float humidity;
	/**
	 * Non-default constructor for an instance of the Weather 
	 * @param temp temperature that's represented as a float
	 * @param feels_like feels_like is what the weather feels like and is represented as a float
	 * @param temp_min temp_min is the minimum temperature that's represented as a float
	 * @param temp_max temp_max is the maximum temperature that's represented as a float
	 * @param pressure pressure is the pressure thats represented as a float
	 * @param humidity humidity is the humidity thats represented as a float
	 */
	WeatherModel(float temp, float feels_like, float temp_min, float temp_max, float pressure, float humidity){
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
	}
	/**
	 * Default constructor for an instance of the weather
	 */
	WeatherModel()
	{
		this.temp=0;
		this.feels_like=0;
		this.temp_min=0;
		this.temp_max=0;
		this.pressure=0;
		this.humidity=0;
		
	}
	/**
	 * getter for the temperature of the weather
	 * @return it returns the temperature as a float
	 */
	public float getTemp() {
		return temp;
	}
	/**
	 * setter for the temperature of the weather
	 * @param temp temp is the temperature being set 
	 */
	public void setTemp(float temp) {
		this.temp = temp;
	}
	/**
	 * getter for feels like of the weather
	 * @return it returns the feels_like as a float
	 */
	public float getFeels_like() {
		return feels_like;
	}
	/**
	 * setter for feels like of the weather
	 * @param feels_like is the weather attribute being set
	 */
	public void setFeels_like(float feels_like) {
		this.feels_like = feels_like;
	}
	/**
	 * getter for temp_min of the weather
	 * @return it returns the temp_min as a float
	 */
	public float getTemp_min() {
		return temp_min;
	}
	/**
	 * setter for temp_min of the weather
	 * @param temp_min temp_min is the weather attribute being set
	 */
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}
	/**
	 * getter for temp_max of the weather
	 * @return it returns the temp_max as a float
	 */
	public float getTemp_max() {
		return temp_max;
	}
	/**
	 * setter for temp_max of the weather
	 * @param temp_max temp_max is the weather attribute being set
	 */
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
	/**
	 * getter for pressure of the weather
	 * @return it returns the pressure as a float
	 */
	public float getPressure() {
		return pressure;
	}
	/**
	 * setter for pressure of the weather
	 * @param pressure pressure is the weather attribute being set
	 */
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	/**
	 * getter for humidity of the weather
	 * @return it returns the humidity as a float
	 */
	public float getHumidity() {
		return humidity;
	}
	/**
	 * setter for humidity of the weather
	 * @param humidity humidity is the weather attribute being set
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	//toString method for the weather model
	@Override
	public String toString() {
		return "WeatherModel [temp=" + temp + ", feels_like=" + feels_like + ", temp_min=" + temp_min + ", temp_max="
				+ temp_max + ", pressure=" + pressure + ", humidity=" + humidity + "]";
	}
	
}
