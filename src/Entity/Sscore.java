/**
 * 
 */
package Entity;

/**
 * @author lin
 *
 */
public class Sscore {
	private String sno;
	private int score;
	private String time;
	/**
	 * 
	 */
	public Sscore(String sno,int score,String time) {
		// TODO 自动生成的构造函数存根
		this.sno=sno;
		this.score=score;
		this.time=time;
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
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score 要设置的 score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time 要设置的 time
	 */
	public void setTime(String time) {
		this.time = time;
	}
}