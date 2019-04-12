package edu.autocar.iotmonitor.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import edu.autocar.iotmonitor.dao.SensorDao;
import edu.autocar.iotmonitor.dao.SensorDaoImpl;
import edu.autocar.iotmonitor.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SimpleMqttCallBack implements MqttCallback{
	public void connectionLost(Throwable throwable) {
		System.out.println("Connection to MQTT broker lost!");
	}
	
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception{
		//처음꺼
		System.out.println("Message received:\t" + new String(message.getPayload()));
		
		String msg = new String(message.getPayload());
		String []tokens = topic.split("/");
		
		Sensor s = new Sensor();
		s.setOwner(tokens[0]);
		s.setPlace(tokens[1]);
		s.setSensorType(tokens[2]);
		s.setValue(Double.parseDouble(msg));
		
		SensorDao dao = SensorDaoImpl.getDao();
		dao.insert(s);
		ConnectionProvider.getSqlSession().commit();
	}
	
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
		
	}
	
	
}
