package com.apollo.Todos.dto.response;

import lombok.Data;

@Data
public class PostScheduleResponse {
    private String data;

    public PostScheduleResponse(String data) {
        this.data = data;
    }
}
