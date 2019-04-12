package EchoClientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		Socket socket = null;
		try(ServerSocket server = new ServerSocket(3000)){
			socket = server.accept();
			
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			
			String line = r.readLine();
			System.out.println("서버 수신 메시지 : " + line);
			
			w.println(line);
			w.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(Exception e) {};
		}
	}
}
