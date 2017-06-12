package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DBBean;
import Entity.Question;
import Entity.User;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("gbk");
		String con=request.getParameter("con");
		String a="A."+request.getParameter("a");
		String b="B."+request.getParameter("b");
		String c="C."+request.getParameter("c");
		String d="D."+request.getParameter("d");
		String ans=request.getParameter("ans");
		int qlev=Integer.valueOf(request.getParameter("qlev"));
		Question q=new Question("", con, a, b, c, d, ans, qlev);
		PrintWriter out = response.getWriter();
		DBBean db=new DBBean();
		boolean isSuccess=false;//用于判断用户注册是否成功
		isSuccess=db.insertRecord(q);
			if(isSuccess){
				out.print("success");
			}else {
				out.print("fail");
			}
		out.flush();
		out.close();
	}
}

