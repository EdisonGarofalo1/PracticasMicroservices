package com.aplicativo.venta.models.dto;

public class BaseResponse {

	 private String[] errorMessages;

	    public BaseResponse(String[] errorMessages) {
	        this.errorMessages = errorMessages;
	    }

	    public boolean hasErrors() {
	        return errorMessages != null && errorMessages.length > 0;
	    }

	    public String[] getErrorMessages() {
	        return errorMessages;
	    }

	    public void setErrorMessages(String[] errorMessages) {
	        this.errorMessages = errorMessages;
	    }
}
