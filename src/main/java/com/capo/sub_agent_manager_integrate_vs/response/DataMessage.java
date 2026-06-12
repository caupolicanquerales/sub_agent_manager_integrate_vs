package com.capo.sub_agent_manager_integrate_vs.response;

public class DataMessage {
	
	private String message;
	private DataToolCall toolCall;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataToolCall getToolCall() {
		return toolCall;
	}

	public void setToolCall(DataToolCall toolCall) {
		this.toolCall = toolCall;
	}
	
}
