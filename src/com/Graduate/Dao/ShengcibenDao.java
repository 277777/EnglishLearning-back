package com.Graduate.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.Shengciben;

public interface ShengcibenDao {

	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	public List<Shengciben> SelectMore(int userid) throws Exception;
	
	public String SendStr(Shengciben shengciben);
	
	public int Insertshengci(Shengciben shengciben) throws Exception;
	
}
