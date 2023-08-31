package com.apollo.Todos.dto.response;

import lombok.Data;

@Data
public class PatchScheduleResponse {
    private String data;

    public PatchScheduleResponse(String data) {
        this.data = data;
    }
}
