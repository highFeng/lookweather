package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import db.City;
import db.Country;
import db.Province;

import android.R.bool;
import android.text.TextUtils;

public class Utility {
	/**
	 * ������������ص�ʡ��������
	 */
	public static boolean handlerProvinceResponse(String response){
		if (!TextUtils.isEmpty(response)) {
			try {
				JSONArray allProvince = new JSONArray(response);
				for (int i = 0; i < allProvince.length(); i++) {
					JSONObject provinceObject = allProvince.getJSONObject(i);
					Province province = new Province();
					province.setProvinceCode(provinceObject.getInt("id"));
					province.setProvinceName(provinceObject.getString("name"));
					province.save();
				}
				return true;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * ������������ص��м�������
	 */
	public static boolean handlerCityResponse(String response){
		if (!TextUtils.isEmpty(response)) {
			try {
				JSONArray allCities = new JSONArray(response);
				for (int i = 0; i < allCities.length(); i++) {
					JSONObject cityObject = allCities.getJSONObject(i);
					City city = new City();
					city.setCityCode(cityObject.getInt("id"));
					city.setCityName(cityObject.getString("name"));
					// ʡ����id����������
					city.setProvince(cityObject.getInt("id"));
					city.save();
				}
				return true;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * ������������ص��ؼ�������
	 */
	public static boolean handlerCountryResponse(String response){
		if (!TextUtils.isEmpty(response)) {
			try {
				JSONArray allcountries = new JSONArray(response);
				for (int i = 0; i < allcountries.length(); i++) {
					JSONObject countryObject = allcountries.getJSONObject(i);
					Country country = new Country();
					country.setCityId(countryObject.getInt("id"));
					country.setCountryName(countryObject.getString("name"));
					country.setWeatherId(countryObject.getString("weather_id"));
					country.save();
				}
				return true;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
