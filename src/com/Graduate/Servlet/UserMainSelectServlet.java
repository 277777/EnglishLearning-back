package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.UserMainDaoImpl;
import com.Graduate.Po.UserMain;
import com.Graduate.Tools.Constant;

/**
 * Servlet implementation class UserMainSelectServlet
 */
@WebServlet("/UserMainSelectServlet")
public class UserMainSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMainSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int Userid = Integer.valueOf(request.getParameter("Userid"));
		UserMain userMain = new UserMain();
		try {
			userMain = new UserMainDaoImpl().findUserMainAll(Userid);
			if(userMain==null)
				response.getOutputStream().write(Constant.DEFEATE.getBytes("UTF-8"));
			else {
				String string= new UserMainDaoImpl().SendUser(userMain);
				response.getOutputStream().write(string.getBytes("UTF-8"));
			}
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
