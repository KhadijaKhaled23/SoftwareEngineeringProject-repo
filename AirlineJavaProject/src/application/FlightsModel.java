package application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.beans.property.*;


public class FlightsModel {
	private final StringProperty From;
	private final StringProperty To;
	private final IntegerProperty Price;
	private final StringProperty Date;
	private final StringProperty Time;
	

	public FlightsModel(String from, String to, Integer price, String date, String time) {
	   
	    this.From = new SimpleStringProperty(from);
	    this.To = new SimpleStringProperty(to);
	    this.Price = new SimpleIntegerProperty(price);
	    this.Date = new SimpleStringProperty(date);
	    this.Time = new SimpleStringProperty(time);
	}
	
	public String getFlightFrom() {
		return From.get();
	}
	
	public String getFlightTo() {
		return To.get();
	}
	
	public Integer getFlightPrice() {
		return Price.get();
	}
	
	public String getFlightDate() {
		return Date.get();
	}
	
	public String getFlightTime() {
		return Time.get();
	}
	
	public void setFlightFrom(String from) {
		From.set(from);
	}
	
	
	public void setFlightTo(String to) {
	    To.set(to);
	}
	
	public void setFlightPrice(int price) {
	    Price.set(price);
	}
	
	public void setFlightTime(String time) {
	    Time.set(time);
	}
	
	public void setFlightDate(String date) {
	    Date.set(date);
	}
	
	
	public StringProperty FlightToProperty() {
		return To;
	}
	
	public StringProperty FlightFromProperty() {
		return From;
	}
	
	public IntegerProperty FlightPriceProperty() {
		return Price;
	}
	
	public StringProperty FlightDateProperty() {
		return Date;
	}
	
	public StringProperty FlightTimeProperty() {
		return Time;
	}
	
};










