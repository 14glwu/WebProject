/**
 * 
 */
package Entity;

/**
 * @author lin
 *
 */
public class User {
		private String sno;
		private String psw;
		private int lev;
		
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
	 * @param sno 要设置的 sno
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
	 * @param psw 要设置的 psw
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
	 * @param lev 要设置的 lev
	 */
	public void setLev(int lev) {
		this.lev = lev;
	}
	
}
