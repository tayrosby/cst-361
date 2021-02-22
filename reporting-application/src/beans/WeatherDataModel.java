package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class WeatherDataModel {

	//weather attributes
	float temp;
	float feels_like;
	float temp_min;
	float temp_max;
	float pressure;
	float humidity;
	
	
	
	/**
	 * constructor
	 */
	public WeatherDataModel() {
		super();
		this.temp = 0;
		this.feels_like = 0;
		this.temp_min = 0;
		this.temp_max = 0;
		this.pressure = 0;
		this.humidity = 0;
	}

	/**
	 * constructor
	 * @param temp
	 * @param feelsLike
	 * @param min
	 * @param max
	 * @param pressure
	 * @param humidity
	 */
	public WeatherDataModel(float temp, float feels_like, float temp_min, float temp_max, float pressure, float humidity) {
		super();
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
	}

	//getters and setters
	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(float feels_like) {
		this.feels_like = feels_like;
	}

	public float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	public float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "WeatherDataModel [temp=" + temp + ", feels_like=" + feels_like + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + ", pressure=" + pressure + ", humidity=" + humidity + "]";
	}
	
	

}
