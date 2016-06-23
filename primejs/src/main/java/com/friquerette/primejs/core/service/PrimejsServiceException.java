package com.friquerette.primejs.core.service;

/**
 * 
 * @author Rick
 *
 */
public class PrimejsServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1346627984579144295L;
	private String errCode;
	private String errMsg;
	private String causeMsg;

	public PrimejsServiceException() {
		super();
	}

	public PrimejsServiceException(String errMsg) {
		this.errMsg = errMsg;
	}

	public PrimejsServiceException(String errMsg, Throwable cause) {
		this.errMsg = errMsg;
		this.causeMsg = "" + cause;
	}

	public PrimejsServiceException(String errCode, String errMsg, Throwable cause) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.causeMsg = "" + cause;
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

	public String getCauseMsg() {
		return causeMsg;
	}

	public void setCauseMsg(String causeMsg) {
		this.causeMsg = causeMsg;
	}

}
