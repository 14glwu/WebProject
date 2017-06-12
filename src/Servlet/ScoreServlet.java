/**
 * 
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DBBean;
import Entity.Sscore;
import Entity.User;

/**
 * @author lin
 *
 */
public class ScoreServlet extends HttpServlet{
	/**
	 * 
	 */
	public ScoreServlet() {
	}
	
	public void destroy(){
	super.destroy();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws 
	ServletException,IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws 
	ServletException,IOException{	
//		PrintWriter out=response.getWriter();
		int score=Integer.valueOf(request.getParameter("score"));
		String   time=request.getParameter("time");     
		time=java.net.URLDecoder.decode(time,"utf-8");    
		User user=(User)request.getSession().getAttribute("user");
		DBBean db=new DBBean();
		Sscore sscore=new Sscore(user.getSno(), score, time);
		boolean isSuccess=false;//判断成绩是否插入成功
		isSuccess=db.insertRecord(sscore);//插入成绩
//		if (isSuccess) {
//			out.print("success");
//		}
//		else{
//			out.print("fail");
//		}
//		out.flush();
//		out.close();
	}
}
