package com.friquerette.primems.controller.web;

/**
 * 
 * @author Rick
 *
 */
public class PrimemsWebException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -933702172607154836L;

	private String errCode;

	private String errMsg;

	public PrimemsWebException() {
		super();

	}

	public PrimemsWebException(String errMsg) {
		this.errMsg = errMsg;
	}

	public PrimemsWebException(String errMsg, Throwable cause) {
		this.errMsg = errMsg;
	}

	public PrimemsWebException(String errCode, String errMsg, Throwable cause) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
