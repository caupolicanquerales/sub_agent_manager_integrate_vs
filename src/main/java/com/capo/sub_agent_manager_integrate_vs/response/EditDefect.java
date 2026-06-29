package com.capo.sub_agent_manager_integrate_vs.response;

public record EditDefect(String action, Integer startLine, Integer startColumn, Integer endLine,
		Integer endColumn, String content) {

}
