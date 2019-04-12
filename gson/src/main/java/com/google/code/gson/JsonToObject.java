package com.google.code.gson;

import com.google.gson.Gson;

public class JsonToObject {

	public static void main(String[] args) {
		try {
			String json = FileUtil.readAll("C:/Temp/sensor.json");
			Gson gson = new Gson();
			
			//단일 객체 복원
			Sensor sensor = gson.fromJson(json, Sensor.class);
			System.out.println(sensor);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
