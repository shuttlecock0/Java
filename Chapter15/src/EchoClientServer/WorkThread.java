package EchoClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkThread extends Thread{
	private Socket socket;
	
	public WorkThread(Socket socket) { // 생성자를 통해 클라이언트 socket 받음
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter w = new PrintWriter(socket.getOutputStream());

			// 메시지 수신
			String line = r.readLine();
			System.out.println("서버 수신 메시지 : " + line);

			// 메시지 전송
			w.println(line);
			w.flush();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				socket.close();
			}
			catch(IOException e) {
				System.out.println(e);
			}
		}
	}
}
