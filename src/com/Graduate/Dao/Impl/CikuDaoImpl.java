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
import org.json.JSONArray;

import com.Graduate.Dao.CikuDao;
import com.Graduate.Po.CiKu;

public class CikuDaoImpl implements CikuDao {

	private SqlSession session;
	public static String json;
	
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
	public List<Map<Integer, String>> SelectCiku(int chrose) throws Exception {
		session = GetXML();
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		List<CiKu> listciku = new ArrayList<CiKu>();
		switch(chrose) {
		case 1:
			listciku  = session.selectList("CiKuDB.SelectCetf");
			break;
		case 2:
			listciku  = session.selectList("CiKuDB.SelectCets");
			break;
		case 3:
			listciku  = session.selectList("CiKuDB.SelectKaoYan");
			break;
		case 4:
			listciku  = session.selectList("CiKuDB.SelectGRE");
			break;
			default:
				break;
		}
		session.close();
		System.out.println("长度："+listciku.size()+"内容名字："+listciku.get(0).getWord());
		for(int i=0;i<listciku.size();i++) {
			Map<Integer,String> map = new HashMap<Integer,String>();
			map.put(1, ""+listciku.get(i).getWordid());
			map.put(2, listciku.get(i).getWord());
			map.put(3,""+listciku.get(i).getList());
			list.add(map);
		}
		json = new JSONArray(list).toString();
		return list;
	}
	

}
