package com.Graduate.Dao;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.Restudy;

public interface RestudyDao {

	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	public Restudy SelectMore(Restudy restudy) throws Exception;
	
	public String SendStr(Restudy restudy);
	
	public int SetStudy(Restudy restudy,int mouth) throws Exception;
	
}
