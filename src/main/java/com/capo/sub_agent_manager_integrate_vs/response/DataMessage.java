package com.capo.sub_agent_manager_integrate_vs.response;

public class DataMessage {
	
	private String message;
	private String type;
	private DataToolCall toolCall;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DataToolCall getToolCall() {
		return toolCall;
	}

	public void setToolCall(DataToolCall toolCall) {
		this.toolCall = toolCall;
	}
	
}
