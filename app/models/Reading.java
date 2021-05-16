package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
  public Date time;
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;
  public double windDirection;

  public Reading(Date time, int code, double temperature, double windSpeed, double windDirection, int pressure)
  {
    this.time = time;
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
  }

  public Date getTime() {
    return time;
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
