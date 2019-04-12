package EchoClientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		try(Socket socket = new Socket("127.0.0.1", 10000)){
			//수신용 Reader 만들기
			BufferedReader r = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			Scanner s = new Scanner(System.in);
			System.out.println("문자열 입력> ");
			String line = s.nextLine(); // 전송할 문자열 입력
			//메시지 전송
			w.println(line);
			w.flush();
			
			//메시지 수신
			String receiveLine = r.readLine();
			System.out.println("수신 메시지 :" + receiveLine);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
