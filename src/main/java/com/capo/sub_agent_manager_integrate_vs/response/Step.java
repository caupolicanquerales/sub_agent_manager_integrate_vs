package com.capo.sub_agent_manager_integrate_vs.response;

public record Step(String id, String title, String description, String type, Boolean waitForCompletion, Payload payload) {

}
