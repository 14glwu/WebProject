package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DBBean;
import Entity.Sscore;
import Entity.User;

/**
 * Servlet implementation class RankServlet
 */
@WebServlet("/RankServlet")
public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankServlet() {
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
        String action = request.getParameter("action");//获取用户的操作
        if("single".equals(action)){//执行登录操作
            this.doSingle(request, response);
        }
        if("all".equals(action)){//执行注册操作
            this.doAll(request, response);
        }
	}
	
	protected void doSingle(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		DBBean db=new DBBean();
		List<Sscore> sscores=null;
		User user=(User)request.getSession().getAttribute("user");
		sscores=db.getSingleSscores(user);//获取个人成绩集
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>排名</th>");
		out.println("<th>学号</th>");
		out.println("<th>成绩</th>");
		out.println("<th>提交时间</th>");
		out.println("</tr>");
		int count=0;
		for(Sscore s:sscores){
			count++;
			out.println("<tr>");
			out.println("<td>"+count+"</td>");
			out.println("<td>"+s.getSno()+"</td>");
			out.println("<td>"+s.getScore()+"</td>");
			out.println("<td>"+s.getTime()+"</td>");
			out.println("</tr>");
		}
		out.flush();
		out.close();
	}
	
	protected void doAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		DBBean db=new DBBean();
		List<Sscore> sscores=null;
		sscores=db.getAllSscores();//获取所有人成绩集
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>排名</th>");
		out.println("<th>学号</th>");
		out.println("<th>成绩</th>");
		out.println("<th>提交时间</th>");
		out.println("</tr>");
		int count=0;
		for(Sscore s:sscores){
			count++;
			out.println("<tr>");
			out.println("<td>"+count+"</td>");
			out.println("<td>"+s.getSno()+"</td>");
			out.println("<td>"+s.getScore()+" 分</td>");
			out.println("<td>"+s.getTime()+"</td>");
			out.println("</tr>");
		}
		out.flush();
		out.close();
	}

}
