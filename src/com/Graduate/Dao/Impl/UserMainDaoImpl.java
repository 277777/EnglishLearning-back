package com.Graduate.Dao.Impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.UserMainDao;
import com.Graduate.Po.UserMain;

public class UserMainDaoImpl implements UserMainDao {

	public SqlSession session;
	
	@Override
	public SqlSession GetXML() throws Exception {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}

	@Override
	public int Register(UserMain userMain) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		result = session.insert("UserMainDB.Register", userMain);
		session.commit();
		session.close();
		System.out.println("这是："+result+"    "+userMain.getUsermainid());
		if(result==1)
			return userMain.getUsermainid();
		else return 0;
	}

	@Override
	public String SendUser(UserMain userMain) {
		// TODO Auto-generated method stub
		String string = null;
		string = userMain.getUsermainid()+"#"+userMain.getUsermainname()+
				"#"+userMain.getUsermainsex()+"#"+userMain.getUsermaincollege()+
				"#"+userMain.getUsermainclass()+"#"+userMain.getUsermainemail();
		return string;
	}

	@Override
	public UserMain findUserMainAll(int userid) throws Exception{
		// TODO Auto-generated method stub
		session = GetXML();
		UserMain userMain = session.selectOne("UserMainDB.findUserMainAll", userid);
		session.close();
		return userMain;
	}

}
