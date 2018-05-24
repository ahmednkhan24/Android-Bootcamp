package com.londonappbrewery.climapm;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    //  Declare the member variables here
    private int mCondition;
    private String mTemperature;
    private String mCity;
    private String mIconName;

    // Create a WeatherDataModel from a JSON:
    public static WeatherDataModel fromJson(JSONObject obj) {
        try {
            WeatherDataModel data = new WeatherDataModel();
            data.mCity = obj.getString("name");
            data.mCondition = obj.getJSONArray("weather").getJSONObject(0).getInt("id");
            data.mIconName = updateWeatherIcon(data.mCondition);

            // convert kelvin to fahrenheit
            double temp = (obj.getJSONObject("main").getDouble("temp") - 273.15) * 9.0 / 5.0 + 32;
            int roundUp = (int) Math.rint(temp);
            data.mTemperature = Integer.toString(roundUp);

            return data;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    // get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // Create getter methods for temperature, city, and icon name:
    public String getTemperature() {
        return mTemperature + "°";
    }

    public void setTemperature(String temperature) {
        mTemperature = temperature;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getIconName() {
        return mIconName;
    }

    public void setIconName(String iconName) {
        mIconName = iconName;
    }
}
