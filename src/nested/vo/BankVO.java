package com.programs.nested.vo;

/**
 * @author "Jigar Gosalia"
 *
 */
public class BankVO {

	/**
	 * 
	 */
	private AccountVO accountVO;

	/**
	 * @return
	 */
	public AccountVO getAccountVO() {
		return accountVO;
	}

	/**
	 * @param accountVO
	 */
	public void setAccountVO(AccountVO accountVO) {
		this.accountVO = accountVO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankVO[Account=" + this.accountVO + "]";
	}
}
