package com.Graduate.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface CikuDao {

	// 获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	public List<Map<Integer,String>> SelectCiku(int chrose) throws Exception;
}
