package com.capo.sub_agent_manager_integrate_vs.response;

import java.util.List;

public record DataStepPlanError(String errorSummary, List<Step> steps) {

}
