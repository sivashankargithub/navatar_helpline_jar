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
	
	
}
