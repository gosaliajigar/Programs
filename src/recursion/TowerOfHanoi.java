package recursion;

/**
 * The mission is to move all the disks to some another tower without violating
 * the sequence of arrangement. The below mentioned are few rules which are to
 * be followed for tower of hanoi -<br>
 * 
 * 1. Only one disk can be moved among the towers at any given time.<br> 
 * 2. Only the "top" disk can be removed.<br>
 * 3. No large disk can sit over a small disk.<br>
 * <br>
 * 
 * Tower of hanoi puzzle with n disks can be solved in minimum (2^n)−1 steps.
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class TowerOfHanoi {
	private int numOfDisks;

	public TowerOfHanoi(int disks) {
		this.numOfDisks = disks;
	}

	public void solve() {
		moveTower(this.numOfDisks, 1, 3, 2);
	}

	public void moveTower(int numOfDisks, int source, int destination, int extra) {
		if (numOfDisks == 1) {
			move(numOfDisks, source, destination);
		} else {
			// src=1 dest=2 ext=3
			moveTower(numOfDisks - 1, source, extra, destination);
			move(numOfDisks, source, destination);
			// src=2 dest=3 ext=1
			moveTower(numOfDisks - 1, extra, destination, source);
		}
	}

	public void move(int disk, int start, int end) {
		System.out.println("Move " + disk + "th disk from " + start + " to " + end);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TowerOfHanoi p = new TowerOfHanoi(3);
		p.solve();
	}
}
