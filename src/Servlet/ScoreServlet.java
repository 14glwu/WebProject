/**
 * 
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DBBean;
import Entity.Question;
import Entity.Sscore;
import Entity.User;

/**
 * @author lin
 *
 */
public class ScoreServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public ScoreServlet() {
		super();
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
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		int score=Integer.valueOf(request.getParameter("score"));
		String   time=request.getParameter("time");     
		time=java.net.URLDecoder.decode(time,"utf-8");
		DBBean db=new DBBean();
		User user=(User)request.getSession().getAttribute("user");
		int lev=user.getLev();
		if((score>=90)&&(lev!=3)){
			lev++;
			user.setLev(lev);
		}
		db.changeUserLev(user);//修改用户等级
		Sscore sscore=new Sscore(user.getSno(), score, time);
		boolean isSuccess=false;//判断成绩是否插入成功
		isSuccess=db.insertRecord(sscore);//插入成绩
		request.getSession().setAttribute("user",user);//重新给session设置user
		//重新生成问题集
		List<Question> questions = null;
		questions = db.getQuestions(user);//根据用户等级获取问题集
		request.getSession().setAttribute("questions", questions);//问题集存在session中
		if (isSuccess) {
			out.print("success");
		}
		else{
			out.print("fail");
		}
		out.flush();
		out.close();
	}
}
