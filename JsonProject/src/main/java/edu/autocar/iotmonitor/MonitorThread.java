package edu.autocar.iotmonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;

import edu.autocar.iotmonitor.dao.SensorDao;
import edu.autocar.iotmonitor.dao.SensorDaoImpl;
import edu.autocar.iotmonitor.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class MonitorThread extends Thread{
	Socket socket;
	public MonitorThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try(
				BufferedReader r = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				){
			String msg = r.readLine();
			Gson gson = new Gson();
			Sensor[] sensors = gson.fromJson(msg, Sensor[].class);
			
			SensorDao dao = SensorDaoImpl.getDao();
			for(Sensor sensor : sensors) {
				dao.insert(sensor);
			}
			
			//커밋
			ConnectionProvider.getSqlSession().commit();
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
