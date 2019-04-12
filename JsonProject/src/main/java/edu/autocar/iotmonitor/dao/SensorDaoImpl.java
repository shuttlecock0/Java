package edu.autocar.iotmonitor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.iotmonitor.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SensorDaoImpl implements SensorDao{
	static final String namespace = "edu.autocar.iotmonitor.dao.SensorDao.";

	SqlSession sqlSession;

	private static SensorDao dao = new SensorDaoImpl();

	private SensorDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}
    
	public static SensorDao getDao() {
		return dao;
	}
	
	@Override
	public List<Sensor> selectList() throws Exception {
		return sqlSession.selectList(namespace + "selectList");
	}

	@Override
	public Sensor selectOne(Long sensorId) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", sensorId);
	}

	@Override
	public int insert(Sensor member) throws Exception {
		return sqlSession.insert(namespace + "insert", member);
	}

	@Override
	public int update(Sensor sensor) throws Exception {
		return sqlSession.update(namespace + "update", sensor);
	}

	@Override
	public int delete(Long K) throws Exception {
		return sqlSession.delete(namespace + "delete", K);
	}
}
