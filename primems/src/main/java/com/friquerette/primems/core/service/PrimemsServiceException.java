package com.friquerette.primems.core.service;

/**
 * 
 * @author Rick
 *
 */
public class PrimemsServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1195227683352625486L;

	private String errCode;
	private String errMsg;

	public PrimemsServiceException() {
		super();

	}

	public PrimemsServiceException(String errMsg, Throwable cause) {
		this.errMsg = errMsg;
	}

	public PrimemsServiceException(String errCode, String errMsg, Throwable cause) {
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