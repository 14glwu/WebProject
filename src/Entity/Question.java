/**
 * 
 */
package Entity;

/**
 * @author lin
 *
 */
public class Question {
	private String qno;
	private String con;
	private String  a;
	private String  b;
	private String  c;
	private String  d;
	private String  ans;
	private int  qlev;
	/**
	 * 
	 */
	public Question(String qno,String con,String  a, String  b,String  c, String  d, String  ans, int  qlev) {
		// TODO 自动生成的构造函数存根
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
	 * @param qno 要设置的 qno
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
	 * @param con 要设置的 con
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
	 * @param a 要设置的 a
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
	 * @param b 要设置的 b
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
	 * @param c 要设置的 c
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
	 * @param d 要设置的 d
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
	 * @param ans 要设置的 ans
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
	 * @param qlev 要设置的 qlev
	 */
	public void setQlev(int qlev) {
		this.qlev = qlev;
	}
	
	
	

}
