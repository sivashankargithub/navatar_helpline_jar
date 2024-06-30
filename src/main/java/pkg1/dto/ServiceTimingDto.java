package pkg1.dto;

import pkg1.entity.ServiceTimingEntity;

public class ServiceTimingDto {
	private ServiceTimingEntity serviceTimings;
	private long service_provider_id;
	public ServiceTimingDto(ServiceTimingEntity serviceTimings, long service_provider_id) {
		super();
		this.serviceTimings = serviceTimings;
		this.service_provider_id = service_provider_id;
	}
	public ServiceTimingDto() {
		super();
	}
	public ServiceTimingEntity getServiceTimings() {
		return serviceTimings;
	}
	public void setServiceTimings(ServiceTimingEntity serviceTimings) {
		this.serviceTimings = serviceTimings;
	}
	public long getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(long service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	
	
}
