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
	 * Post����
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws
	ServletException,IOException{
        String action = request.getParameter("action");//��ȡ����
        if("login".equals(action)){//�û���½
            this.login(request, response);
        }
        if("register".equals(action)){//�û�ע��
            this.register(request, response);
        }
	}
	
	/**
	 * ����login�������ж��û����������Ƿ���ȷ��
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
		isRight=db.checkRecord(user);//�ж��û��Ƿ��¼�ɹ�
		if(isRight){
			session.setAttribute("user",user);//session����user���ԣ������ж��û��Ƿ��¼��
			List<Question> questions = null;
			questions = db.getQuestions(user);//�����û��ĵȼ���ȡ��Ӧ����Ŀ
			request.getSession().setAttribute("questions", questions);
			List<Question> q = (List<Question>)request.getSession().getAttribute("questions");
			System.out.println("test:" + q.size());
			System.out.println("test:" + questions.size());
			out.print("success");//�û���������ȷ�ͷ����ַ�success
		}else{
			out.print("fail");//ʧ�ܾͷ����ַ�fail
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
		isExist=db.checkRecord(user);//�ж��û��Ƿ�����ע���
		boolean isSuccess=false;//�ж��û��Ƿ�ע��ɹ�
		if(isExist){
			out.print("exist");//����û����ھͷ����ַ�exist
		}else {
			isSuccess=db.insertRecord(user);
			if(isSuccess){
				out.print("success");//ע��ɹ���ͷ����ַ�success
			}else {
				out.print("fail");//ע��ʧ�ܺ�ͷ����ַ�fail
			}
		}
		out.flush();
		out.close();
	}
	
}








