package edu.autocar.base.util;

import java.util.List;
import java.util.Scanner;

public class Input {
	public static String getString(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextLine();
	}	
	
	
	public static int getInt(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextInt();
	}	
	
	public static int selectList(List<String> list) {
		for(int i=0;i<list.size(); i++) {
			System.out.printf("%d] %s\n", i+1, list.get(i));
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("선택 : ");
		return scanner.nextInt()-1;
	}
	
	public static int selectList(String[] arr) {
		for(int i=0;i<arr.length; i++) {
			System.out.printf("%d] %s\n", i+1, arr[i]);
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("선택 : ");
		return scanner.nextInt()-1;
	}
	
	public static String getMultiLine(String msg) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.println(msg);		
		while(true) {
			String line = scanner.nextLine();
			if(line.equals("END")) break;
			sb.append(line + "\r\n");
		}
		return sb.toString();
	}
}
