package controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.ChartModel;
import beans.WeatherDataModel;
import business.WeatherManager;

@ManagedBean
@ViewScoped
public class WeatherController 
{
	//instance of weather novels
	public WeatherManager manager = new WeatherManager();
	
	/**
	 * displays the tabular chart
	 * @return - data table page
	 */
	public String displayTable()
	{
		List<WeatherDataModel> list = manager.getAllWeather();
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("list", list);
		return "DataTable.xhtml";
	}
	
	/**
	 * displays the line chart
	 * @return - line chart page
	 */
	public String displayLineChart()
	{
		ChartModel model = new ChartModel();
		model = manager.getWeatherChart(model);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("chart", model);
		return "LineChart.xhtml";
	}

	/**
	 * navigation
	 * @return - main menu
	 */
	public String moveTo() {
		return "MainMenu.xhtml";
	}
}