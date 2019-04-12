package EchoClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkThread extends Thread{
	private Socket socket;
	
	public WorkThread(Socket socket) { // �����ڸ� ���� Ŭ���̾�Ʈ socket ����
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter w = new PrintWriter(socket.getOutputStream());

			// �޽��� ����
			String line = r.readLine();
			System.out.println("���� ���� �޽��� : " + line);

			// �޽��� ����
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
