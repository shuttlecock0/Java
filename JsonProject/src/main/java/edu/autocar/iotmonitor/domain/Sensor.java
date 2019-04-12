package edu.autocar.iotmonitor.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sensor {
	long sensorId;
	String sensorType;
	double value;
	Date regDate;
	String owner;
	String place;
}
