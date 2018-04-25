package com.Graduate.Dao.Impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.WordsDao;
import com.Graduate.Po.RandOM;
import com.Graduate.Po.Words;

public class WordsDaoImpl implements WordsDao {

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
	public String[] SelectWords(RandOM num) throws Exception {
		session = GetXML();
		String[] liststr = new String[4];
		List<Words> list = new ArrayList<Words>();
		list  = session.selectList("WordsDB.SelectWords",num);
		System.out.println(list);
		session.close();
		for(int i=0;i<list.size();i++) {
			String string = list.get(i).getMeaning();
			int m = string.indexOf("<br>");
			if(m==-1)
				System.out.println("不包含");
			else {
				System.out.println("包含："+m);
				string = string.replaceFirst("<br>", " ");
			} 
			System.out.println("改变之后："+string);
			liststr[i] = string;
		}
		return liststr;
	}

	@Override
	public int SelectID(String string) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result  = session.selectOne("WordsDB.SelectID",string);
		session.close();
		return result;
	}

}
