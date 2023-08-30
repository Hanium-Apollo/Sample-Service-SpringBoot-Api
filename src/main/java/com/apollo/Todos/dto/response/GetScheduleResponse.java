package com.apollo.Todos.dto.response;

import com.apollo.Todos.domain.Schedule;
import lombok.Data;

import java.util.List;

@Data
public class GetScheduleResponse {
    private List<Schedule> schedules;
}
