package com.capo.sub_agent_manager_integrate_vs.response;

import java.util.List;

public record DataEditDefect(String id, String filepath, String status, String explanation,
		List<EditDefect> edits) {

}
