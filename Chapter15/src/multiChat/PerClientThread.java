package multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread{
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket;
	PrintWriter writer;
	
	PerClientThread(Socket socket){
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#" + name + "님이 들어오셨습니다.");
			while(true) {
				String str = reader.readLine(); // 메시지 수신
				if(str == null)
					break;
				sendAll(name + ">" + str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			list.remove(writer); //리스트에서 출력 스트림 제거
			sendAll("#" + name + "님이 나가셨습니다.");
			try {
				socket.close();
			}catch(Exception e) {}
		}
	}
	
	//접속한 모든 사용자에게 메시지 포워딩
	private void sendAll(String str) {
		for(PrintWriter writer : list) {
			writer.println(str);
			writer.flush();
		}
	}
}
