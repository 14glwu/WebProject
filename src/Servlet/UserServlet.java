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
	/**
	 * Post方法
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws
	ServletException,IOException{
        String action = request.getParameter("action");//获取操作
        if("login".equals(action)){//用户登陆
            this.login(request, response);
        }
        if("register".equals(action)){//用户注册
            this.register(request, response);
        }
	}
	
	/**
	 * 处理login动作，判断用户名和密码是否正确。
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		 response.setContentType("text/html");
		 response.setCharacterEncoding("gbk");
		 PrintWriter out = response.getWriter();
		String sno=request.getParameter("sno");
		System.out.print(sno);
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		User user=new User(sno, password, 1);
		DBBean db=new DBBean();	
		boolean isRight=false;
		isRight=db.checkRecord(user);//判断用户是否登录成功
		if(isRight){
			session.setAttribute("user",user);//session设置user属性，用于判断用户是否登录过
			List<Question> questions = null;
			questions = db.getQuestions(user);//根据用户的等级获取相应的题目
			request.getSession().setAttribute("questions", questions);
			List<Question> q = (List<Question>)request.getSession().getAttribute("questions");
			System.out.println("test:" + q.size());
			System.out.println("test:" + questions.size());
			out.print("success");//用户名密码正确就返回字符success
		}else{
			out.print("fail");//失败就返回字符fail
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
		boolean isExist=false;
		isExist=db.checkRecord(user);//判断用户是否曾经注册过
		boolean isSuccess=false;//判断用户是否注册成功
		if(isExist){
			out.print("exist");//如果用户存在就返回字符exist
		}else {
			isSuccess=db.insertRecord(user);
			if(isSuccess){
				out.print("success");//注册成功后就返回字符success
			}else {
				out.print("fail");//注册失败后就返回字符fail
			}
		}
		out.flush();
		out.close();
	}
	
}








