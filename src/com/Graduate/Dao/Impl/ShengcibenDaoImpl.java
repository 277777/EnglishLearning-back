package com.Graduate.Dao.Impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.ShengcibenDao;
import com.Graduate.Po.Shengciben;

public class ShengcibenDaoImpl implements ShengcibenDao {

	private SqlSession session;

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
	public List<Shengciben> SelectMore(int userid) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		List<Shengciben> listciku = new ArrayList<Shengciben>();
		listciku = session.selectList("ShengcibenDB.SelectMore",userid);
		session.close();
		return listciku;
	}

	@Override
	public String SendStr(Shengciben shengciben) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Insertshengci(Shengciben shengciben) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		result = session.insert("ShengcibenDB.Insertshengci", shengciben);
		session.commit();
		session.close();
		return result;
	}

}
