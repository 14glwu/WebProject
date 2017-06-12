/**
 * 
 */
package Bean;

/**
 * @author lin
 *
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Question;
import Entity.Sscore;
import Entity.User;

import com.mysql.jdbc.Connection;

public class DBBean {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String ADDRESS = "jdbc:mysql://localhost/exam";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	Connection con = null;
	Statement stat = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	public DBBean() {}
	
	/**
	 * 建立数据库连接
	 * @return
	 */
	public Connection getCon(){
		try{
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			String url = "jdbc:mysql://localhost:3306/helloqky?user=root&password=root&useUnicode=true&characterEncoding=utf-8";
//	        con = DriverManager.getConnection(url);
			Class.forName(DRIVER);
		    con = (Connection) DriverManager.getConnection(ADDRESS, USER, PASSWORD);
		    if (con != null && !con.isClosed()) 
			{
				System.out.println("MySQL Connection Succeeded!");
			} 
			else 
			{
				System.err.println("MySQL Connection Failed!");
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return con;		
	}
	
	/**
	 * 执行查询语句
	 * @param sql
	 * @return
	 */
	public ResultSet query(String sql){
		try{
			con = getCon();
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 执行更新sql语句
	 * @param sql
	 */
	public void update(String sql){
		try{
			con = getCon();
			stat = con.createStatement();
			stat.executeUpdate(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * 执行多条更新sql语句
	 * @param sql
	 * @param args
	 */
	public void update(String sql,String[] args){
		try{
			con = getCon();
			pstat = con.prepareStatement(sql);
			for (int i=0;i<args.length;i++){
				pstat.setString(i+1,args[i]);
			}
			pstat.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 插入一条用户记录
	 * @param user
	 * @return
	 */
	public boolean insertRecord (User user)
	{
		PreparedStatement pstmt=null;
		
		if(user==null)return false;
		try{
			con=getCon();
			String sql = "INSERT INTO student(sno,psw) VALUES(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,user.getSno());
			pstmt.setString(2,user.getPsw());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e)
		 {e.printStackTrace();}
		 finally{close();}
		return true;
	}
	/**
	 * 插入一条考题记录
	 * @param user
	 * @return
	 */
	public boolean insertRecord (Question question)
	{
		PreparedStatement pstmt=null;
		
		if(question==null)return false;
		try{
			con=getCon();
			String sql = "INSERT INTO question(con,a,b,c,d,ans,qlev) VALUES(?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,question.getCon());
			pstmt.setString(2,question.getA());
			pstmt.setString(3,question.getB());
			pstmt.setString(4,question.getC());
			pstmt.setString(5,question.getD());
			pstmt.setString(6,question.getAns());
			pstmt.setInt(7,question.getQlev());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e)
		 {e.printStackTrace();}
		 finally{close();}
		return true;
	}
	
	/**
	 * 修改用户等级
	 * @param user
	 * @return
	 */
	public boolean changeUserLev (User user)
	{
		con=getCon();
		if(user==null) return false;
		String sno = user.getSno();
		int lev = user.getLev();
		String sql = "update student set lev='"+lev+"' where sno='"+sno+"'";
		update(sql);
		return true;
	}
	
	/**
	 * 插入一条成绩记录
	 * @param score
	 * @return
	 */
	public boolean insertRecord (Sscore score)
	{
		PreparedStatement pstmt=null;
		
		if(score==null)return false;
		try{
			con=getCon();
			//id是自增属性，不需要插入
			String sql = "INSERT INTO score(sno,score,time) VALUES(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,score.getSno());
			pstmt.setInt(2,score.getScore());
			pstmt.setString(3,score.getTime());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e)
		 {e.printStackTrace();}
		 finally{close();}
		return true;
	}
	
	/**
	 * 检查是否已经有该用户
	 * @param user
	 * @return
	 */
	public boolean checkRecord(User user)
	{
		con=getCon();
		String sno = user.getSno();
		String psw = user.getPsw();
		String sql = "select * from student where sno='"+sno+"' and psw='"+psw+"'";
		ResultSet rs = query(sql);
		try {
			boolean right=rs.next();
			return right;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据用户等级获取试卷的问题集
	 * @param user
	 * @return
	 */
	public List<Question> getQuestions(User user){
		List<Question> questions = new ArrayList<Question>();
		con=getCon();
		String sql = "select * from  Question where qlev='"+user.getLev()+"' order by rand()";
		ResultSet rs = query(sql);
		try {
			while(rs.next()){
				questions.add(new Question(
						rs.getString("Qno"),
						rs.getString("Con"),
						rs.getString("A"),
						rs.getString("B"),
						rs.getString("C"),
						rs.getString("D"),
						rs.getString("Ans"),
						rs.getInt("Qlev")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  questions;
	}
	
	/**
	 * 获取所有用户成绩集，降序排序
	 * @param user
	 * @return
	 */
	public List<Sscore> getAllSscores(){
		List<Sscore> sscores= new ArrayList<Sscore>();
		con=getCon();
		String sql = "select * from score order by score desc";
		try{
			pstat = con.prepareStatement(sql);
			rs = pstat.executeQuery();
			while(rs.next()){
				sscores.add(new Sscore(rs.getString("sno"),
						rs.getInt("score"),
						rs.getString("time")
						) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return sscores;
	}
	
	/**
	 * 获取用户个人成绩集，降序排序
	 * @param user
	 * @return
	 */
	public List<Sscore> getSingleSscores(User user){
		List<Sscore> sscores= new ArrayList<Sscore>();
		con=getCon();
		String sql = "select * from score where sno='"+user.getSno()+"' order by score desc";
		try{
			pstat = con.prepareStatement(sql);
			rs = pstat.executeQuery();
			while(rs.next()){
				sscores.add(new Sscore(rs.getString("sno"),
						rs.getInt("score"),
						rs.getString("time")
						) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return sscores;
	}
	
	public void close(){
		try{
			if (rs != null)rs.close();
			if (stat != null)stat.close();
			if (pstat != null)pstat.close();
			if (con != null)con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}	
	
}
