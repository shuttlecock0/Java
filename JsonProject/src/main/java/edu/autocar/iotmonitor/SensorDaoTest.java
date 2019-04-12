package edu.autocar.iotmonitor;

import java.util.List;

import edu.autocar.iotmonitor.dao.SensorDao;
import edu.autocar.iotmonitor.dao.SensorDaoImpl;
import edu.autocar.iotmonitor.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SensorDaoTest {
	public static void main(String[] args) {
		selectListTest();
		ConnectionProvider.getSqlSession().close();
	}
	
	public static void selectListTest() {
		SensorDao dao = SensorDaoImpl.getDao();
		try {
			List<Sensor> list = dao.selectList();
			System.out.println(list.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
