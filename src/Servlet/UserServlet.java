package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.DBBean;
import Entity.Question;
import Entity.User;


public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public  UserServlet() {
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
        String action = request.getParameter("action");//获取用户的操作
        if("login".equals(action)){//执行登录操作
            this.login(request, response);
        }
        if("register".equals(action)){//执行注册操作
            this.register(request, response);
        }
	}
	
	public void login(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		String sno=request.getParameter("sno");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		User user=new User(sno, password, 1);
		DBBean db=new DBBean();	
		boolean isRight=false;//判断用户登录是否成功
		isRight=db.checkRecord(user);
		if(isRight){
			session.setAttribute("user",user);//用户信息存在session中
			List<Question> questions = null;
			questions = db.getQuestions(user);//根据用户等级获取问题集
			session.setAttribute("questions", questions);//问题集存在session中
			out.print("success");
		}else{
			out.print("fail");
		}
		out.flush();
		out.close();
	}
	
	public  void register(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		 response.setContentType("text/html");
		 response.setCharacterEncoding("gbk");
		String sno=request.getParameter("sno");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		User user=new User(sno, password, 1);
		DBBean db=new DBBean();
		boolean isExist=false;//判断用户是否存在
		isExist=db.checkRecord(user);
		boolean isSuccess=false;//用于判断用户注册是否成功
		if(isExist){
			out.print("exist");
		}else {
			isSuccess=db.insertRecord(user);
			if(isSuccess){
				out.print("success");
			}else {
				out.print("fail");
			}
		}
		out.flush();
		out.close();
	}
	
}








