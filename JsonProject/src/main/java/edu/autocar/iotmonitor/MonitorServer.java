package edu.autocar.iotmonitor;

import java.net.ServerSocket;
import java.net.Socket;

public class MonitorServer {
	public static void main(String[] args) {
		Socket socket = null;
		try(ServerSocket server = new ServerSocket(10000)){
			System.out.println("서버 준비 완료");
			while(true) {
				socket = server.accept();
				System.out.println("Client가 연결 완료");
				MonitorThread mThread = new MonitorThread(socket);
				mThread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
