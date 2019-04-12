package EchoClientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		try(Socket socket = new Socket("127.0.0.1", 10000)){
			//���ſ� Reader �����
			BufferedReader r = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			Scanner s = new Scanner(System.in);
			System.out.println("���ڿ� �Է�> ");
			String line = s.nextLine(); // ������ ���ڿ� �Է�
			//�޽��� ����
			w.println(line);
			w.flush();
			
			//�޽��� ����
			String receiveLine = r.readLine();
			System.out.println("���� �޽��� :" + receiveLine);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
