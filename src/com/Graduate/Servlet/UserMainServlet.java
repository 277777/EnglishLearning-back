package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.UserDaoImpl;
import com.Graduate.Dao.Impl.UserMainDaoImpl;
import com.Graduate.Po.User;
import com.Graduate.Po.UserMain;
import com.Graduate.Tools.Constant;
import com.Graduate.Tools.Escape;


/**
 * Servlet implementation class UserMainServlet
 */
@WebServlet("/UserMainServlet")
public class UserMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMainServlet() {
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
		String Usermainname = Escape.unescape(request.getParameter("Usermainname"));
		String Usermainsex;
		if(request.getParameter("Usermainsex").equals("w"))
			Usermainsex = "女";
		else  
			Usermainsex = "男";
		String Usermaincollege = Escape.unescape(request.getParameter("Usermaincollege"));
		String Usernameclass = Escape.unescape(request.getParameter("Usernameclass"));
		String Usermainemail = Escape.unescape(request.getParameter("Usermainemail"));
		UserMain userMain = new UserMain();
		userMain.setUsermainname(Usermainname);
		userMain.setUsermainsex(Usermainsex);
		userMain.setUsermaincollege(Usermaincollege);
		userMain.setUsermainclass(Usernameclass);
		userMain.setUsermainemail(Usermainemail);
		try {
			int result = new UserMainDaoImpl().Register(userMain);
			if(result!=0) {
				User user = new User();
				user.setUserid(userid);
				user.setUsermainid(result);
				int res = new UserDaoImpl().UpdateUserMain(user);
				if(res==1)
					response.getWriter().print(result);
				else response.getWriter().print(Constant.DEFEATE);
			}
			else response.getWriter().print(Constant.DEFEATE);
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
