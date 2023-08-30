package com.apollo.Todos.repository;

import com.apollo.Todos.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
