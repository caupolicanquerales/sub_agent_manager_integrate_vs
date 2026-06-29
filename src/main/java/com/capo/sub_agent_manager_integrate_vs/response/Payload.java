package com.capo.sub_agent_manager_integrate_vs.response;

public record Payload(String command, String cwd, String filepath, String pathType, String line, String context, String insertionMode, String find, String replace, String instruction) {

}
