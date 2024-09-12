package com.sf.honeymorning.domain.alarm.repository;

import com.sf.honeymorning.domain.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
