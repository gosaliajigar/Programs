package hashcode.equals;

/**
 * Dog Class implements equals and hashCode.
 *  
 * @author "Jigar Gosalia"
 *
 */
public class Dog {

	private String color;

	private int type;

	public Dog(final String color, final int type) {
		this.setColor(color);
		this.setType(type);
	}

	public String getColor() { return color; }

	public void setColor(final String color) { this.color = color; }

	public int getType() { return type; }

	public void setType(int type) { this.type = type; }

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		/* According to Joshua Bloch's Effective Java<br>
		 * <br>
		 * The value 31 was chosen because it is an odd prime. If it were even and
		 * the multiplication overflowed, information would be lost, as
		 * multiplication by 2 is equivalent to shifting.<br> <br>
		 * <br>
		 * The advantage of using a prime is less clear, but it is traditional. A
		 * nice property of 31 is that the multiplication can be replaced by a shift
		 * and a subtraction for better performance: 31 * i == (i << 5) - i. Modern
		 * VMs do this sort of optimization automatically.
		 */
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + type;
		// result = 31 * (31 * 1 + color.hashCode()) + type;
		// result = 31^2 + 31*color.hashCode() + type
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (this.getClass() != obj.getClass()) return false;
		Dog other = (Dog) obj;
		if (this.color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	@Override
	public String toString() { return "Dog [color=" + color + ", type=" + type + "]"; }
}
