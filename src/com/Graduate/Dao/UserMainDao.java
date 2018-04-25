package com.Graduate.Dao;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.UserMain;

public interface UserMainDao {

	// 获取UserDB.xml
	public SqlSession GetXML() throws Exception;

	// 注册-insert-user
	public int Register(UserMain userMain) throws Exception;

	// 整理字符串
	public String SendUser(UserMain userMain);
	
	public UserMain findUserMainAll(int userid) throws Exception;

}
