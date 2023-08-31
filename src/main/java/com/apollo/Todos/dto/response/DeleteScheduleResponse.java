package com.apollo.Todos.dto.response;

import lombok.Data;

@Data
public class DeleteScheduleResponse {
    private String data;

    public DeleteScheduleResponse(String data) {
        this.data = data;
    }
}
