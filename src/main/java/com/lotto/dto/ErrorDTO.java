package com.lotto.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="lotto")
public class ErrorDTO {
	private long errorCode;
	private String errorMessage;
	public long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
