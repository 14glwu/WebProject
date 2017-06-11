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
	
	public void update(String sql){
		try{
			con = getCon();
			stat = con.createStatement();
			stat.executeUpdate(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

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
	public boolean insertRecord (User user)
	{
		PreparedStatement pstmt=null;
		
		if(user==null)return false;
		try{
			con=getCon();
			String sql = "INSERT INTO student(sno,psw) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,user.getSno().toString());
			pstmt.setString(2,user.getPsw().toString());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e)
		 {e.printStackTrace();}
		 finally{close();}
		return true;
	}
	
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