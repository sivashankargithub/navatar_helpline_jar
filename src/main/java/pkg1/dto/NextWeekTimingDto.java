package pkg1.dto;

import java.util.List;
import java.util.Optional;

import pkg1.entity.ServiceTimingEntity;

public class NextWeekTimingDto {
	private Optional<ServiceTimingEntity> st;
	private List<String>slots1;
		
	public NextWeekTimingDto() {
		super();
	}

	public NextWeekTimingDto(Optional<ServiceTimingEntity> st, List<String> slots1) {
		super();
		this.st = st;
		this.slots1 = slots1;
	}

	public Optional<ServiceTimingEntity> getSt() {
		return st;
	}

	public void setSt(Optional<ServiceTimingEntity> st) {
		this.st = st;
	}

	public List<String> getSlots1() {
		return slots1;
	}

	public void setSlots1(List<String> slots1) {
		this.slots1 = slots1;
	}	
}
