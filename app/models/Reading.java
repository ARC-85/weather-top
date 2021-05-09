package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;
  public double windDirection;

  public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure)
  {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
  }

  public int getCode() {
    return code;
  }

  public double getTemp() {
    return temperature;
  }

  public double getWind() {
    return windSpeed;
  }

  public int getPressure() {
    return pressure;
  }

  public double getWindDirection() {
    return windDirection;
  }
}
