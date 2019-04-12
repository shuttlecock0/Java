package TCPIP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {
	public static void main(String[] args) {
		Socket socket = null;
		//���� ���� ����
		try(ServerSocket serverSocket = new ServerSocket(10000);){
			socket = serverSocket.accept();
			
			//���� (�Է�) ��Ʈ��
			InputStream in = socket.getInputStream();
			
			//���� (���) ��Ʈ��
			OutputStream out = socket.getOutputStream();
			
			byte arr[] = new byte[100];
			in.read(arr); //�޽��� ����
			System.out.println(new String(arr));
			
			String str = "Hello, Client";
			out.write(str.getBytes());	//�޽��� ����
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
