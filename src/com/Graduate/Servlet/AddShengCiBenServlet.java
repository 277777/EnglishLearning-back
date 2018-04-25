package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.ShengcibenDaoImpl;
import com.Graduate.Po.Shengciben;
import com.Graduate.Tools.Constant;


/**
 * Servlet implementation class AddShengCiBenServlet
 */
@WebServlet("/AddShengCiBenServlet")
public class AddShengCiBenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShengCiBenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*				String path = ConNet.ADDSHENGCIBENURL+"?Userid="+ConClass.getUser().getUsername()+
						"&Word="+list.get(learning-1).get(2);
		 * */
		int userid = Integer.valueOf(request.getParameter("Userid"));
		String word = request.getParameter("Word");
		Shengciben shengciben = new Shengciben();
		shengciben.setUserid(userid);
		shengciben.setShengcibenname(word);
		try {
			int result = new ShengcibenDaoImpl().Insertshengci(shengciben);
			if(result==1)
				response.getWriter().print(Constant.SUCCESSFUL);
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
