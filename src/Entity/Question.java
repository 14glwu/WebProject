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
		// TODO �Զ����ɵĹ��캯�����
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
	 * @param qno Ҫ���õ� qno
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
	 * @param con Ҫ���õ� con
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
	 * @param a Ҫ���õ� a
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
	 * @param b Ҫ���õ� b
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
	 * @param c Ҫ���õ� c
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
	 * @param d Ҫ���õ� d
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
	 * @param qlev Ҫ���õ� qlev
	 */
	public void setQlev(int qlev) {
		this.qlev = qlev;
	}
	
	
	

}
