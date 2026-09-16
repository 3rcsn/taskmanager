package com.ercsn.taskmanager.infrastructure.http.response;

import com.ercsn.taskmanager.application.output.TaskOutput;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TaskResponse (String id, String title, String description){
    public static TaskResponse from(TaskOutput output) {
        return new TaskResponse(output.title(),
                output.description().orElse(null),
                output.status());
    }
}
