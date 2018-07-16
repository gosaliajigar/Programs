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

	public int getI() { return i; }
	public void setI(final int i) { this.i = i; }

	public int getJ() { return j; }
	public void setJ(final int j) { this.j = j; }

	public int getK() { return k; }
	public void setK(final int k) { this.k = k; }

	public CompositeClass getCompositeClass() { return compositeClass; }
	public void setCompositeClass(final CompositeClass compositeClass) { this.compositeClass = compositeClass; }

	@Override
	public CloneableClass clone() throws CloneNotSupportedException { return new CloneableClass(); }
	public CloneableClass() { this.compositeClass = new CompositeClass(); }
}
