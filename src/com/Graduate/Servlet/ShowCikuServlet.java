package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.CikuDaoImpl;

/**
 * Servlet implementation class CikuUploadServlet
 */
@WebServlet("/ShowCikuServlet")
public class ShowCikuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCikuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int cikuid = Integer.valueOf(request.getParameter("Cikuid"));
		CikuDaoImpl cikuDaoImpl = new CikuDaoImpl();
		try {
			switch(cikuid) {
			case 1:
				cikuDaoImpl.SelectCiku(1);
				break;
			case 10:
				cikuDaoImpl.SelectCiku(2);
				break;
			case 100:
				cikuDaoImpl.SelectCiku(3);	
				break;
			case 1000:
				cikuDaoImpl.SelectCiku(4);
				break;
				default:
					break;
			}
			System.out.print(CikuDaoImpl.json);
			response.getWriter().print(CikuDaoImpl.json);
		}catch (Exception e) {
			// TODO: handle exception
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
