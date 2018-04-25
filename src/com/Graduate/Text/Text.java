package com.Graduate.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.Graduate.Dao.Impl.CikuDaoImpl;

public class Text {

	public static void main(String[] args) {
		try {
			CikuDaoImpl cikuDaoImpl = new CikuDaoImpl();
			cikuDaoImpl.SelectCiku(1);
			System.out.print(cikuDaoImpl.json);
			changejsontolist(cikuDaoImpl.json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<List<Map<Integer,String>>> changejsontolist(String string) throws Exception {
		Map<Integer, String> map;
		List<Map<Integer,String>> listmap = new ArrayList<Map<Integer,String>>();
		List<List<Map<Integer,String>>> list = new ArrayList<List<Map<Integer,String>>>();
		JSONArray jsonstr = new JSONArray(string);
        System.out.println(jsonstr);
        System.out.println(jsonstr.length());
        for(int i=0;i<10;i++){
        	for(int j=0;j<10;j++) {
        		JSONObject jsonObject = jsonstr.getJSONObject(i*10+j);
              map = new HashMap<Integer, String>();
              map.put(1,jsonObject.get("1").toString());
              map.put(2,jsonObject.get("2").toString());
              listmap.add(map);
        	}
        	list.add(listmap);
        }
        
        System.out.println(list.size()+"    "+listmap.size()+"    "+list);
		return list;
        
	}
	
}
