package com.google.code.gson;

import java.util.Arrays;

import com.google.gson.Gson;

public class JsonToArray {

	public static void main(String[] args) {
		try {
			String json = FileUtil.readAll("C:/Temp/sensor_array.json");
			Gson gson = new Gson();
			
			//배열로 복원하기
			Sensor[] arr = gson.fromJson(json, Sensor[].class);
			System.out.println(Arrays.toString(arr));
			
			//배열을 JSON으로 변환
			String json_arr = gson.toJson(arr);
			System.out.println(json_arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
