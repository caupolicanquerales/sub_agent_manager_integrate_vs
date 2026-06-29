package com.capo.sub_agent_manager_integrate_vs.response;


public record Defect(String id, String severity, String category, String title, 
		String description, Coordinates coordinates, Context context) {

}
