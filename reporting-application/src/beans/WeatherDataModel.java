package beans;

public class WeatherDataModel {

	//weather attributes
	float temp;
	float feelsLike;
	float min;
	float max;
	float pressure;
	float humidity;
	
	/**
	 * constructor
	 */
	public WeatherDataModel() {
		this.temp = 0;
		this.feelsLike = 0;
		this.min = 0;
		this.max = 0;
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
	public WeatherDataModel(float temp, float feelsLike, float min, float max, float pressure, float humidity) {
		super();
		this.temp = temp;
		this.feelsLike = feelsLike;
		this.min = min;
		this.max = max;
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

	public float getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(float feelsLike) {
		this.feelsLike = feelsLike;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
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
	
	

}
