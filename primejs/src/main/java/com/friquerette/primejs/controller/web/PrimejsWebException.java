package com.friquerette.primejs.controller.web;

/**
 * 
 * @author Rick
 *
 */
public class PrimejsWebException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -933702172607154836L;

	private String errCode;

	private String errMsg;

	public PrimejsWebException() {
		super();

	}

	public PrimejsWebException(String errMsg) {
		this.errMsg = errMsg;
	}

	public PrimejsWebException(String errMsg, Throwable cause) {
		this.errMsg = errMsg;
	}

	public PrimejsWebException(String errCode, String errMsg, Throwable cause) {
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
