package com.capo.sub_agent_manager_integrate_vs.service;

import org.springframework.stereotype.Service;

import com.capo.sub_agent_manager_integrate_vs.response.DataMessage;

@Service
public class MapReplayLastResponseService {
	
	private final static String TERMINAL = "terminal";
	private final static String TERMINAL_COMMAND = "terminalCommand";

	// Shell command prefixes that mark the start of the actual command
	private static final String[] COMMAND_PREFIXES = { "cd ", "mvn ", "npm ", "./gradlew ", "gradle " };

	public DataMessage mapReplayLastResponse(String content, String agent) {
		if (agent.equals(TERMINAL_COMMAND)) {
			return mapReplayLastResponseTerminalCommand(content);
		}
		return mapReplayLastResponseDefault(content);
	}

	private DataMessage mapReplayLastResponseTerminalCommand(String content) {
		DataMessage dataMessage = new DataMessage();
		dataMessage.setType(TERMINAL);
		dataMessage.setMessage(extractCommand(content));
		return dataMessage;
	}

	/**
	 * Strips any LLM prose prefix and returns only the shell command.
	 * Finds the earliest occurrence of a known command prefix (e.g. "cd ", "mvn ")
	 * and returns the substring from that point onwards.
	 */
	private String extractCommand(String content) {
		if (content == null || content.isBlank()) return content;
		int earliest = -1;
		for (String prefix : COMMAND_PREFIXES) {
			int idx = content.indexOf(prefix);
			if (idx >= 0 && (earliest < 0 || idx < earliest)) {
				earliest = idx;
			}
		}
		return earliest >= 0 ? content.substring(earliest).trim() : content.trim();
	}

	private DataMessage mapReplayLastResponseDefault(String content) {
		DataMessage dataMessage = new DataMessage();
		dataMessage.setMessage(content);
		return dataMessage;
	}
}
