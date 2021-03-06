package nested.vo;

/**
 * @author "Jigar Gosalia"
 *
 */
public class AccountVO {
	
	private int id;
	
	private CustomerVO customerVO;

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	/**
	 * @param customerVO
	 */
	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountVO[id=" + this.id + ";Customer=" + this.customerVO + "]";
	}
}
