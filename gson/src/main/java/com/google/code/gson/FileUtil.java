package com.google.code.gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtil {
	public static String readAll(String path) throws Exception{
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(
				new FileReader(path));){
			int ch;
			while((ch=br.read())!=-1) {
				sb.append((char)ch);
			}
		}
		return sb.toString();
	}
}
