package com.Graduate.Dao.Impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.RestudyDao;
import com.Graduate.Po.Restudy;

public class RestudyDaoImpl implements RestudyDao {

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
	public Restudy SelectMore(Restudy restudy) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		restudy = session.selectOne("RestudyDB.SelectMore", restudy);
		session.close();
		return restudy;
	}

	@Override
	public String SendStr(Restudy restudy) {
		// TODO Auto-generated method stub
		String string = restudy.getRestuid()+"#"+restudy.getUserid()+"#"+restudy.getMon()+
				"#"+restudy.getTue()+"#"+restudy.getWed()+"#"+restudy.getThu()+"#"+restudy.getFri()+
				"#"+restudy.getSat()+"#"+restudy.getSun();
		return string;
	}

	@Override
	public int SetStudy(Restudy restudy, int mouth) throws Exception {
		session = GetXML();
		int result = 0;
//		result = session.update("UserDB.UpdatePassword", user);
		switch(mouth) {
		case 1:
			result = session.update("RestudyDB.UpdateMon", restudy);
			break;
		case 2:
			result = session.update("RestudyDB.UpdateTue", restudy);
			break;
		case 3:
			result = session.update("RestudyDB.UpdateWed", restudy);
			break;
		case 4:
			result = session.update("RestudyDB.UpdateThu", restudy);
			break;
		case 5:
			result = session.update("RestudyDB.UpdateFri", restudy);
			break;
		case 6:
			result = session.update("RestudyDB.UpdateSat", restudy);
			break;
		case 7:
			result = session.update("RestudyDB.UpdateSun", restudy);
			break;
			default:
				break;
		}
		session.commit();
		session.close();
		return result;
	}

}
