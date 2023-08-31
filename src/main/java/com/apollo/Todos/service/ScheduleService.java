package com.apollo.Todos.service;

import com.apollo.Todos.domain.Schedule;
import com.apollo.Todos.dto.request.PostScheduleRequest;
import com.apollo.Todos.dto.response.DeleteScheduleResponse;
import com.apollo.Todos.dto.response.GetScheduleResponse;
import com.apollo.Todos.dto.response.PatchScheduleResponse;
import com.apollo.Todos.dto.response.PostScheduleResponse;
import com.apollo.Todos.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    @Transactional
    public PostScheduleResponse saveSchedule(PostScheduleRequest request){
        scheduleRepository.save(new Schedule(request.getContent()));
        return new PostScheduleResponse("Schedule is posted successfully");
    }
    public GetScheduleResponse findAllSchedules(){
        return new GetScheduleResponse(scheduleRepository.findAll());
    }
    @Transactional
    public PatchScheduleResponse updateSchedule(Long scheduleId, String content){
        Schedule updatedSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("스케쥴 아이디 이상함"))
                .updateSchedule(content);
        return new PatchScheduleResponse("Schedule is updated successfully");
    }
    @Transactional
    public DeleteScheduleResponse deleteSchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("스케쥴 아이디 이상함"));
        scheduleRepository.delete(schedule);
        return new DeleteScheduleResponse("Schedule is deleted successfully");
    }
}
