package nested.vo;

/**
 * @author "Jigar Gosalia"
 *
 */
public class AccountVO {
	/**
	 * 
	 */
	private CustomerVO customerVO;

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
		return "AccountVO[Customer=" + this.customerVO + "]";
	}
}
