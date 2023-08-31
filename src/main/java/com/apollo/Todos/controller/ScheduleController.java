package com.apollo.Todos.controller;

import com.apollo.Todos.dto.request.PostScheduleRequest;
import com.apollo.Todos.dto.response.DeleteScheduleResponse;
import com.apollo.Todos.dto.response.GetScheduleResponse;
import com.apollo.Todos.dto.response.PatchScheduleResponse;
import com.apollo.Todos.dto.response.PostScheduleResponse;
import com.apollo.Todos.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping("/schedule")
    public PostScheduleResponse saveSchedule(@RequestBody PostScheduleRequest request){
        return scheduleService.saveSchedule(request);
    }
    @GetMapping("/schedule")
    public GetScheduleResponse findAllSchedules(){
        return scheduleService.findAllSchedules();
    }
    @PatchMapping("/schedule/{scheduleId}")
    public PatchScheduleResponse updateSchedule(@PathVariable Long scheduleId, @RequestBody PostScheduleRequest request){
        return scheduleService.updateSchedule(scheduleId, request.getContent());
    }
    @DeleteMapping("/schedule/{scheduleId}")
    public DeleteScheduleResponse deleteSchedule(@PathVariable Long scheduleId){
        return scheduleService.deleteSchedule(scheduleId);
    }
}
