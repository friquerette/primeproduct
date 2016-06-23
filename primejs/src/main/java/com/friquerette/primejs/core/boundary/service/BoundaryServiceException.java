package com.friquerette.primejs.core.boundary.service;

/**
 * 
 * @author Rick
 *
 */
public class BoundaryServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1195227683352625486L;

	private String errCode;
	private String errMsg;
	private String causeMsg;

	public BoundaryServiceException() {
		super();
	}

	public BoundaryServiceException(String errMsg, Throwable cause) {
		this.errMsg = errMsg;
		this.causeMsg = "" + cause;
	}

	public BoundaryServiceException(String errCode, String errMsg, Throwable cause) {
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
