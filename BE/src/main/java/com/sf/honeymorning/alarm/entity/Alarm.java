package com.sf.honeymorning.alarm.entity;

import java.time.LocalTime;

import com.sf.honeymorning.domain.common.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "alarms")
@Entity
public class Alarm extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;

	private LocalTime wakeUpTime;

	/**
	 * 알람을 비트마스킹으로 표현합니다.
	 * 맨 오른쪽 부터 월요일입니다.
	 * 맨 왼쪽 비트는 사용하지 않아요.
	 * 예시)
	 * - 0100 0000 = Sunday only
	 * - 0100 0001 = Monday and Sunday
	 * - 0011 0010 = TuesDay and Thursday and Saturday
	 * - 0111 1111 = Every day
	 */
	private byte weekdays;

	private Integer repeatFrequency;

	private Integer repeatInterval;

	private boolean isActive;

	private String musicFilePath;

	protected Alarm() {
	}

	public Alarm(Long userId,
		LocalTime wakeUpTime,
		byte weekdays,
		Integer repeatFrequency,
		Integer repeatInterval,
		boolean isActive,
		String musicFilePath) {
		this.userId = userId;
		this.wakeUpTime = wakeUpTime;
		this.weekdays = weekdays;
		this.repeatFrequency = repeatFrequency;
		this.repeatInterval = repeatInterval;
		this.isActive = isActive;
		this.musicFilePath = musicFilePath;
	}

	public static Alarm initialize(Long userId) {
		return new Alarm(
			userId,
			LocalTime.of(7, 0),
			(byte)0,
			0,
			0,
			false,
			""
		);
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public LocalTime getWakeUpTime() {
		return wakeUpTime;
	}

	public byte getWeekdays() {
		return weekdays;
	}

	public Integer getRepeatFrequency() {
		return repeatFrequency;
	}

	public Integer getRepeatInterval() {
		return repeatInterval;
	}

	public boolean isActive() {
		return isActive;
	}

	public String getMusicFilePath() {
		return musicFilePath;
	}

	public void set(LocalTime alarmTime, byte weekDays, Integer repeatFrequency, Integer repeatInterval,
		boolean isActive) {
		this.wakeUpTime = alarmTime;
		this.weekdays = weekDays;
		this.repeatFrequency = repeatFrequency;
		this.repeatInterval = repeatInterval;
		this.isActive = isActive;
	}
}
