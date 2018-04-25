package com.Graduate.Dao;


import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.RandOM;

public interface WordsDao {

	// 获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	public String[] SelectWords(RandOM num) throws Exception;
	
	public int SelectID(String string) throws Exception;
}
