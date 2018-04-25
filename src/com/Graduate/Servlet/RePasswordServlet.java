package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.UserDaoImpl;
import com.Graduate.Po.User;
import com.Graduate.Tools.Constant;

/**
 * Servlet implementation class RePassword
 */
@WebServlet("/RePasswordServlet")
public class RePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * 		if(string.equals(Constant.SUCCESSFUL)) {
			dispose();
		}else if(string.equals(Constant.DEFEATE)) {
			JOptionPane.showMessageDialog(null, "修改失败，请稍后再试","警告",JOptionPane.ERROR_MESSAGE);
		}else if(string.equals(Constant.NOUSER)) {
			textFieldname.setText("");
			passwordFieldpwd.setText("");
			textFieldtele.setText("");
			JOptionPane.showMessageDialog(null, "用户信息不匹配","警告",JOptionPane.ERROR_MESSAGE);
		}
		 * */
		String username = request.getParameter("Name");
		String password = request.getParameter("Pwd");
		String Tele = request.getParameter("Tele");
		User user = new User();
		user.setUsername(username);
		user.setUsertele(Tele);
		try {
			user = new UserDaoImpl().repassword(user);
			if(user==null)
				response.getWriter().print(Constant.NOUSER);
			else {
				user.setUserpwd(password);
				int result = new UserDaoImpl().UpdatePassword(user);
				if(result==1)
					response.getWriter().print(Constant.SUCCESSFUL);
				else response.getWriter().print(Constant.DEFEATE);
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
