package controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped ;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import beans.ChartModel;
import beans.WeatherDataModel;
import business.WeatherManagerInterface;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class) 
@Named
@ViewScoped
public class WeatherController  implements Serializable {
	
	@EJB
	WeatherManagerInterface manager;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * displays the tabular chart
	 * @return - data table page
	 */
	public String displayTable()
	{
		try {
			List<WeatherDataModel> list = manager.getAllWeather();
			
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("list", list);
			return "DataTable.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception.xhtml";
		}
	}
	
	/**
	 * displays the line chart
	 * @return - line chart page
	 */
	public String displayLineChart()
	{
		try {
			ChartModel model = new ChartModel();
			model = manager.getWeatherChart(model);
			
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("chart", model);
			return "LineChart.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception.xhtml";
		}
	}

	/**
	 * navigation
	 * @return - main menu
	 */
	public String moveTo() {
		return "MainMenu.xhtml";
	}
}
