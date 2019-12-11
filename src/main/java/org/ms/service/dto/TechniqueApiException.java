package org.ms.service.dto;

public class TechniqueApiException extends Exception {

	private String messages;
	public TechniqueApiException(String messages) {
		this.messages = messages;
	}
}
