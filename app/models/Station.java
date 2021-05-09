package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model
{
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public double lat;
  public double lng;

  public Station(String name, double lat, double lng)
  {
    this.name = name;
    this.lat = lat;
    this.lng = lng;
  }

  public String weatherType() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      if (currentReading.getCode() == 100) {
        return "Clear";
      } else if (currentReading.getCode() == 200) {
        return "Partial Clouds";
      } else if (currentReading.getCode() == 300) {
        return "Cloudy";
      } else if (currentReading.getCode() == 400) {
        return "Light Showers";
      } else if (currentReading.getCode() == 500) {
        return "Heavy Showers";
      } else if (currentReading.getCode() == 600) {
        return "Rain";
      } else if (currentReading.getCode() == 700) {
        return "Snow";
      } else if (currentReading.getCode() == 800) {
        return "Thunder";
      } else
        return "Fine";
    }
    else {
      return "No readings available.";
    }
  }

  public String fahrenheit() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      double fahrenheitTemp = currentReading.getTemp() * 9 / 5 + 32;
      String fahrenheit = fahrenheitTemp + " Fahrenheit";
      return fahrenheit;
    }
    else {
      return "No readings available.";
    }
  }

  public String celsius() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      String celsius = currentReading.getTemp() + " Celsius";
      return celsius;
    }
    else {
      return "No readings available.";
    }
  }

  public String pressure() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      String pressure = currentReading.getPressure() + " hPa";
      return pressure;
    }
    else {
      return "No readings available.";
    }
  }

  public String windBeaufort() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      if (currentReading.getWind() <=1) {
        return "Beaufort 0 (Calm)";
      } else if ((currentReading.getWind() >1) && (currentReading.getWind() <=5)) {
        return "Beaufort 1 (Light Air)";
      } else if ((currentReading.getWind() >5) && (currentReading.getWind() <=11)) {
        return "Beaufort 2 (Light Breeze)";
      } else if ((currentReading.getWind() >11) && (currentReading.getWind() <=19)) {
        return "Beaufort 3 (Gentle Breeze)";
      } else if ((currentReading.getWind() >19) && (currentReading.getWind() <=28)) {
        return "Beaufort 4 (Moderate Breeze)";
      } else if ((currentReading.getWind() >28) && (currentReading.getWind() <=38)) {
        return "Beaufort 5 (Fresh Breeze)";
      } else if ((currentReading.getWind() >38) && (currentReading.getWind() <=49)) {
        return "Beaufort 6 (Strong Breeze)";
      } else if ((currentReading.getWind() >49) && (currentReading.getWind() <=61)) {
        return "Beaufort 7 (Near Gale)";
      } else if ((currentReading.getWind() >61) && (currentReading.getWind() <=74)) {
        return "Beaufort 8 (Gale)";
      } else if ((currentReading.getWind() >74) && (currentReading.getWind() <=88)) {
        return "Beaufort 9 (Severe Gale)";
      } else if ((currentReading.getWind() >88) && (currentReading.getWind() <=102)) {
        return "Beaufort 10 (Strong Storm)";
      } else if ((currentReading.getWind() >102) && (currentReading.getWind() <=117)) {
        return "Beaufort 11 (Violent Storm)";
      } else
        return "Perfect Storm";
    }
    else {
      return "No readings available.";
    }
  }

  public String windDirection() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      if ((currentReading.getWindDirection() >=348.75) && (currentReading.getWindDirection() <=360.00)) {
        return "North";
      } else if ((currentReading.getWindDirection() >=0) && (currentReading.getWindDirection() <11.25)) {
        return "North";
      } else if ((currentReading.getWindDirection() >=11.25) && (currentReading.getWindDirection() <33.75)) {
        return "North North East";
      } else if ((currentReading.getWindDirection() >=33.75) && (currentReading.getWindDirection() <56.25)) {
        return "North East";
      } else if ((currentReading.getWindDirection() >=56.25) && (currentReading.getWindDirection() <78.75)) {
        return "East North East";
      } else if ((currentReading.getWindDirection() >=78.75) && (currentReading.getWindDirection() <101.25)) {
        return "East";
      } else if ((currentReading.getWindDirection() >=101.25) && (currentReading.getWindDirection() <123.75)) {
        return "East South East";
      } else if ((currentReading.getWindDirection() >=123.75) && (currentReading.getWindDirection() <146.25)) {
        return "South East";
      } else if ((currentReading.getWindDirection() >=146.25) && (currentReading.getWindDirection() <168.75)) {
        return "South South East";
      } else if ((currentReading.getWindDirection() >=168.75) && (currentReading.getWindDirection() <191.25)) {
        return "South";
      } else if ((currentReading.getWindDirection() >=191.25) && (currentReading.getWindDirection() <213.75)) {
        return "South South West";
      } else if ((currentReading.getWindDirection() >=213.75) && (currentReading.getWindDirection() <236.25)) {
        return "South West";
      } else if ((currentReading.getWindDirection() >=236.25) && (currentReading.getWindDirection() <258.75)) {
        return "West South West";
      } else if ((currentReading.getWindDirection() >=258.75) && (currentReading.getWindDirection() <281.25)) {
        return "West";
      } else if ((currentReading.getWindDirection() >=281.25) && (currentReading.getWindDirection() <303.75)) {
        return "West North West";
      } else if ((currentReading.getWindDirection() >=303.75) && (currentReading.getWindDirection() <326.25)) {
        return "North West";
      } else if ((currentReading.getWindDirection() >=326.25) && (currentReading.getWindDirection() <348.75)) {
        return "North North West";
      } else
        return "Even Breeze";
    }
    else {
      return "No readings available.";
    }
  }

  public String windChill() {
    if (readings.size() !=0) {
      Reading currentReading = readings.get(readings.size() - 1);
      double windChill = 13.12 + 0.6215*currentReading.getTemp() - 11.37*(Math.pow(currentReading.getWind(),0.16)) + 0.3965*(Math.pow(currentReading.getTemp(),0.16));
      double windChill2 = toTwoDecimalPlaces(windChill);
      String windTemp = "Feels like " + windChill2 + " Celsius";
      return windTemp;
    }
    else {
      return "No readings available.";
    }
  }

  private double toTwoDecimalPlaces(double num){
    return (int) (num *100 ) /100.0;
  }
}