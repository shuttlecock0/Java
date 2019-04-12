package EchoClientServer;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer3 {
	public static void main(String[] args) {
		Socket socket = null;
		try (ServerSocket server = new ServerSocket(10000)) {
			while (true) {
				socket = server.accept();
				WorkThread work = new WorkThread(socket);
				work.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
