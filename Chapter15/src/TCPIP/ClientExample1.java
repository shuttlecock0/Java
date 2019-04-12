package TCPIP;

import java.io.*;
import java.net.*;

public class ClientExample1 {

	public static void main(String[] args) {
		try(Socket socket = new Socket("127.0.0.1", 10000)){
			InputStream in = socket.getInputStream(); // ����(�Է�) ��Ʈ��
			OutputStream out = socket.getOutputStream(); //����(���) ��Ʈ��
			String str = "Hello, Server";
			out.write(str.getBytes()); // �޽��� ����
			out.flush();
			
			byte arr[] = new byte[100]; //���� ����
			in.read(arr); //�޽��� ����
			System.out.println(new String(arr));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
