package com.programs.hashcode.equals;

/**
 * Dog Class implements equals and hashCode
 *
 * @author "Jigar Gosalia"
 *
 */
public class Dog {

	/**
	 *
	 */
	private String color;

	/**
	 * @param color
	 */
	Dog(final String color) {
		this.setColor(color);
	}

	/**
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 */
	public void setColor(final String color) {
		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object dog) {
		if (dog == null) {
			return false;
		}
		if (!(dog instanceof Dog)) {
			return false;
		}
		if (dog == this) {
			return true;
		}
		return color.equals(((Dog) dog).getColor());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.getColor().length();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dog : [" + color + "]";
	}
}
