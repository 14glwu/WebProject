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
		// TODO �Զ����ɵĹ��캯�����
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
	 * @param sno Ҫ���õ� sno
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
	 * @param score Ҫ���õ� score
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
	 * @param time Ҫ���õ� time
	 */
	public void setTime(String time) {
		this.time = time;
	}
}