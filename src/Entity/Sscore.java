/**
 * 
 */
package Entity;

/**
 * @author lin
 *
 */
public class Sscore {
	private String sno;//学号
	private int score;//成绩
	private String time;//成绩提交时间
	/**
	 * 
	 */
	public Sscore(String sno,int score,String time) {
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
	 * @param sno 
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
	 * @param score 
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
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
}