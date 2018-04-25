package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.RestudyDaoImpl;
import com.Graduate.Po.Restudy;
import com.Graduate.Tools.Constant;

/**
 * Servlet implementation class UpdateReStudyServlet
 */
@WebServlet("/UpdateReStudyServlet")
public class UpdateReStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReStudyServlet() {
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
		int mouth = Integer.valueOf(request.getParameter("Mouth"));
		Restudy study = new Restudy();
		study.setUserid(userid);
		try {
			int result = new RestudyDaoImpl().SetStudy(study, mouth);
			if(result==1)
				response.getWriter().print(Constant.SUCCESSFUL);
			else 
				response.getWriter().print(Constant.DEFEATE);
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
