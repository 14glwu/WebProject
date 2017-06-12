/**
 * 
 */
package Entity;

/**
 * @author lin
 *
 */
public class Question {
	private String qno;//问题编号
	private String con;//问题内容
	private String  a;//A选项
	private String  b;//B选项
	private String  c;//C选项
	private String  d;//D选项
	private String  ans;//答案
	private int  qlev;//问题难度等级
	/**
	 * 
	 */
	public Question(String qno,String con,String  a, String  b,String  c, String  d, String  ans, int  qlev) {
		this.qno=qno;
		this.con=con;
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.ans=ans;
		this.qlev=qlev;
	}
	/**
	 * @return qno
	 */
	public String getQno() {
		return qno;
	}
	/**
	 * @param qno 
	 */
	public void setQno(String qno) {
		this.qno = qno;
	}
	/**
	 * @return con
	 */
	public String getCon() {
		return con;
	}
	/**
	 * @param con
	 */
	public void setCon(String con) {
		this.con = con;
	}
	/**
	 * @return a
	 */
	public String getA() {
		return a;
	}
	/**
	 * @param a 
	 */
	public void setA(String a) {
		this.a = a;
	}
	/**
	 * @return b
	 */
	public String getB() {
		return b;
	}
	/**
	 * @param b
	 */
	public void setB(String b) {
		this.b = b;
	}
	/**
	 * @return c
	 */
	public String getC() {
		return c;
	}
	/**
	 * @param c
	 */
	public void setC(String c) {
		this.c = c;
	}
	/**
	 * @return d
	 */
	public String getD() {
		return d;
	}
	/**
	 * @param d 
	 */
	public void setD(String d) {
		this.d = d;
	}
	/**
	 * @return ans
	 */
	public String getAns() {
		return ans;
	}
	/**
	 * @param ans Ҫ���õ� ans
	 */
	public void setAns(String ans) {
		this.ans = ans;
	}
	/**
	 * @return qlev
	 */
	public int getQlev() {
		return qlev;
	}
	/**
	 * @param qlev 
	 */
	public void setQlev(int qlev) {
		this.qlev = qlev;
	}
}
