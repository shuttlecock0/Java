package com.google.code.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToList {

	public static void main(String[] args) {
		try {
			String json = FileUtil.readAll("C:/Temp/sensor_array.json");
			Gson gson = new Gson();
			
			Type collectionType = (new TypeToken<ArrayList<Sensor>>() {}).getType();
			
			List<Sensor> list = gson.fromJson(json, collectionType);
			System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
