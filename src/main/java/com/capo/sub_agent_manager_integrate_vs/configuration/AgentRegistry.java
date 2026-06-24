package com.capo.sub_agent_manager_integrate_vs.configuration;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgentRegistry {
	
	@Value(value="${url-general-chat}")
	private String urlGeneralChat;
	
	@Value(value="${url-extracting-order-command-chat}")
	private String urlExtractingOrderCommandChat;
	
	@Value(value="${url-terminal-command-chat}")
	private String urlTerminalCommandChat;
	
	@Value(value="${url-debugger-chat}")
	private String urlDebuggerChat;
	
	@Value(value="${agent-type-general-chat:WEBFLUX}")
	private AgentType agentTypeGeneralChat;
	
	@Value(value="${agent-extracting-order-command-chat:SPRING_MVC}")
	private AgentType agentExtractingOrderCommandChat;
	
	@Value(value="${agent-terminal-command-chat:SPRING_MVC}")
	private AgentType agentTerminalCommandChat;
	
	@Value(value="${agent-debugger-chat:SPRING_MVC}")
	private AgentType agentDebuggerChat;
	
	public Map<String, String> getAgents() {
        return Map.of(
            "general", urlGeneralChat,
            "extractingOrder",urlExtractingOrderCommandChat,
            "terminalCommand",urlTerminalCommandChat,
            "debugger", urlDebuggerChat
        );
    }

	public Map<String, AgentType> getAgentTypes() {
        return Map.of(
            "general", agentTypeGeneralChat,
            "extractingOrder",agentExtractingOrderCommandChat,
            "terminalCommand",agentTerminalCommandChat,
            "debugger", agentDebuggerChat
        );
    }
	
	/**
	 * Agents whose SSE output IS a large JSON/HTML+CSS string that should be stored in Redis
	 * under the key "layout:latest:{conversationId}" so that other agents (or a subsequent
	 * call to layoutArchitect itself) can retrieve it as the current working template.
	 */
	public Map<String, Boolean> getAgentProducingLongString() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.FALSE
        );
    }

	/**
	 * Agents whose SSE output IS a raw base64 image that should be stored in Redis.
	 * Do NOT include agents whose output is LLM text even if they transform images
	 * (e.g. visualEffects stores the result internally via its own Redis tool call).
	 */
	public Map<String, Boolean> getAgentProducingImage() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.FALSE
        );
    }

	/**
	 * Agents that require an existing image Redis key as input (imageReferences).
	 * These agents read the current image from Redis but may or may not stream base64 back.
	 */
	public Map<String, Boolean> getAgentNeedingImageInput() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.FALSE
        );
    }

	public Map<String, Boolean> getAgentNeedingLongStringInput() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.TRUE
        );
    }

	/**
	 * Agents whose SSE output IS synthetic data that should be stored in Redis
	 * under the key "jsonData:latest:{conversationId}" so that iteration calls
	 * can retrieve the previously generated dataset.
	 */
	public Map<String, Boolean> getAgentProducingJsonData() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.TRUE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.TRUE
        );
    }

	/**
	 * Agents that require an existing JSON data Redis key as input (imageReferences).
	 * These agents read the current JSON schema or generated dataset from Redis.
	 */
	public Map<String, Boolean> getAgentNeedingJsonDataInput() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.TRUE,
            "debugger",Boolean.FALSE
        );
    }

	/**
	 * Agents whose SSE output IS a descriptive image-generation prompt (plain text)
	 * that should be stored in Redis under "prompt:latest:{conversationId}" so that
	 * downstream agents (e.g. "image") can use it as their actual prompt instead of
	 * the raw user message.
	 */
	public Map<String, Boolean> getAgentProducingPrompt() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.FALSE
        );
    }

	/**
	 * Agents that should receive the stored prompt (PROMPT_KEY) as their request
	 * prompt instead of the raw user message.
	 */
	public Map<String, Boolean> getAgentNeedingPromptInput() {
        return Map.of(
            "general", Boolean.FALSE,
            "extractingOrder", Boolean.FALSE,
            "terminalCommand",Boolean.FALSE,
            "debugger",Boolean.FALSE
        );
    }

}
