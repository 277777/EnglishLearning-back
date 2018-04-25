package com.Graduate.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.Graduate.Dao.Impl.ShengcibenDaoImpl;
import com.Graduate.Po.Shengciben;

/**
 * Servlet implementation class ShowShengciServlet
 */
@WebServlet("/ShowShengciServlet")
public class ShowShengciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowShengciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int userid = Integer.valueOf(request.getParameter("Userid"));
		try {
			List<Shengciben> list = new ShengcibenDaoImpl().SelectMore(userid);
			List<Map<Integer, String>> listmap = new ArrayList<Map<Integer, String>>();
			for(int i=0;i<list.size();i++) {
				Map<Integer, String> map = new HashMap<Integer, String>();
				map.put(1, list.get(i).getShengcibenname());
				listmap.add(map);
			}
			JSONArray jsonArray = new JSONArray(listmap);
			System.out.println(jsonArray);
			response.getWriter().print(jsonArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
