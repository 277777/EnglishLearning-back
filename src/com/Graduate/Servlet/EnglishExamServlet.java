package com.Graduate.Servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.WordsDaoImpl;
import com.Graduate.Po.RandOM;

/**
 * Servlet implementation class EnglishExamServlet
 */
@WebServlet("/EnglishExamServlet")
public class EnglishExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static int[] num = new int[3];
	private static int[] number = new int[4];
	
    public EnglishExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String string = request.getParameter("Word");
		RandomNumber();
		RandOM randOM = new RandOM();
		String send="";
		int rrr = 0;
		try {
			int s = new WordsDaoImpl().SelectID(string);
			System.out.println("SSSSSSS:"+s);
			for(int i=0;i<4;i++) {
				if(number[i]==0)
					rrr = i+1;
				number[i]+=s;
				System.out.println(number[i]);
			}
			System.out.println(rrr);
			randOM.setA(number[0]);
			randOM.setB(number[1]);
			randOM.setC(number[2]);
			randOM.setD(number[3]);
			String[] str = new WordsDaoImpl().SelectWords(randOM);
			System.out.println(str);
			for(int i=0;i<str.length;i++) {
				send += str[i]+"#";
				System.out.println(str[i]);
			}
			System.out.println(send);
			send+=rrr;
			response.getOutputStream().write(send.getBytes("UTF-8"));;
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

	public void RandomNumber() {
//		new EnglishExamGUI();
        num[0]=(int)(Math.random()*10)-5;
        num[1]=(int)(Math.random()*10)-5;
        num[2]=(int)(Math.random()*10)-5;
        for(int i=0;i<3;i++) {
        	if(num[i]==0)
        		num[i]++;
        	//System.out.println(num[i]);
        }
        Arrays.sort(num);
        number[3] = 0;
        for(int i=0;i<3;i++) {
        	if(num[0]==num[1])
        		num[0]=-12;
        	if(num[1]==num[2])
        		num[2]=12;
        	number[i] = num[i];
        }
        Arrays.sort(number);
        for(int i=0;i<4;i++) {
        	System.out.println(number[i]);
        }
	}	
	
}
