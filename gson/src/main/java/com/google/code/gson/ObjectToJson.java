package com.google.code.gson;

import com.google.gson.Gson;

public class ObjectToJson {

	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			Sensor sensor = new Sensor("humi", 10.2);
			System.out.println(sensor);
			String json = gson.toJson(sensor);
			System.out.println(json);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
