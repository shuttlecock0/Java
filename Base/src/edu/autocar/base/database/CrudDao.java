package edu.autocar.base.database;

import java.util.List;

public interface CrudDao<T, K> {
	List<T> selectList() throws Exception;
	T selectOne(K k) throws Exception;
	int insert(T t) throws Exception;
	int update(T t) throws Exception;
	int delete(K k) throws Exception;
}
