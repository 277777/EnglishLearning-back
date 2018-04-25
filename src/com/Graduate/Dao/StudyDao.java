package com.Graduate.Dao;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.Study;

public interface StudyDao {

	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	public Study SelectMore(Study study) throws Exception;
	
	public String SendStr(Study study);
	
	public int SetStudy(Study study,int mouth) throws Exception;
}
