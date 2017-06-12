/**
 * 
 */
package Entity;

/**
 * @author lin
 *
 */
public class User {
		private String sno;//学号
		private String psw;//答案
		private int lev;//用户级别
		
		public User(String sno,String psw,int lev ){
			this.sno = sno;
			this.psw = psw;
			this.lev = lev;
		}
		/**
	 * @return sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * @param sno 
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * @return psw
	 */
	public String getPsw() {
		return psw;
	}

	/**
	 * @param psw 
	 */
	public void setPsw(String psw) {
		this.psw = psw;
	}

	/**
	 * @return lev
	 */
	public int getLev() {
		return lev;
	}

	/**
	 * @param lev 
	 */
	public void setLev(int lev) {
		this.lev = lev;
	}
	
}
