package marker.interfaces;

/**
 * Class implementing Cloneable
 *
 * @author "Jigar Gosalia"
 *
 */
public class CloneableClass implements Cloneable {

	private int i;

	private int j;

	private int k;

	private CompositeClass compositeClass;

	/**
	 * @return
	 */
	public int getI() {
		return i;
	}

	/**
	 * @param i
	 */
	public void setI(final int i) {
		this.i = i;
	}

	/**
	 * @return
	 */
	public int getJ() {
		return j;
	}

	/**
	 * @param j
	 */
	public void setJ(final int j) {
		this.j = j;
	}

	/**
	 * @return
	 */
	public int getK() {
		return k;
	}

	/**
	 * @param k
	 */
	public void setK(final int k) {
		this.k = k;
	}

	/**
	 * @return
	 */
	public CompositeClass getCompositeClass() {
		return compositeClass;
	}

	/**
	 * @param compositeClass
	 */
	public void setCompositeClass(final CompositeClass compositeClass) {
		this.compositeClass = compositeClass;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	public CloneableClass clone() throws CloneNotSupportedException {
		return new CloneableClass();
	}

	public CloneableClass() {
		this.compositeClass = new CompositeClass();
	}
}
