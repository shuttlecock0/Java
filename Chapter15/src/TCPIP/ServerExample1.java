package TCPIP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {
	public static void main(String[] args) {
		Socket socket = null;
		//서버 소켓 생성
		try(ServerSocket serverSocket = new ServerSocket(10000);){
			socket = serverSocket.accept();
			
			//수신 (입력) 스트림
			InputStream in = socket.getInputStream();
			
			//전송 (출력) 스트림
			OutputStream out = socket.getOutputStream();
			
			byte arr[] = new byte[100];
			in.read(arr); //메시지 수신
			System.out.println(new String(arr));
			
			String str = "Hello, Client";
			out.write(str.getBytes());	//메시지 전송
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(Exception e) {};
		}
	}
}
