package com.programs.nested.vo;

/**
 * @author "Jigar Gosalia"
 *
 */
public class CustomerVO {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private int id;

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerVO[ID=" + this.id + ";Name=" + this.name + "]";
	}
}
