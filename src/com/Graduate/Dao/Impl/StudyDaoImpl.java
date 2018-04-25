package com.Graduate.Dao.Impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.StudyDao;
import com.Graduate.Po.Study;

public class StudyDaoImpl implements StudyDao {

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
	public Study SelectMore(Study study) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		study = session.selectOne("StudyDB.SelectMore", study);
		session.close();
		return study;
	}

	@Override
	public String SendStr(Study study) {
		// TODO Auto-generated method stub
		String string = study.getStuid()+"#"+study.getUserid()+"#"+study.getMon()+
				"#"+study.getTue()+"#"+study.getWed()+"#"+study.getThu()+"#"+study.getFri()+
				"#"+study.getSat()+"#"+study.getSun();
		return string;
	}

	@Override
	public int SetStudy(Study study,int mouth) throws Exception {
		session = GetXML();
		int result = 0;
//		result = session.update("UserDB.UpdatePassword", user);
		switch(mouth) {
		case 1:
			result = session.update("StudyDB.UpdateMon", study);
			break;
		case 2:
			result = session.update("StudyDB.UpdateTue", study);
			break;
		case 3:
			result = session.update("StudyDB.UpdateWed", study);
			break;
		case 4:
			result = session.update("StudyDB.UpdateThu", study);
			break;
		case 5:
			result = session.update("StudyDB.UpdateFri", study);
			break;
		case 6:
			result = session.update("StudyDB.UpdateSat", study);
			break;
		case 7:
			result = session.update("StudyDB.UpdateSun", study);
			break;
			default:
				break;
		}
		session.commit();
		session.close();
		return result;
	}

}
