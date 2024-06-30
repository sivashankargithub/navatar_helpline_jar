package pkg1.dto;

import pkg1.entity.ServiceProviderEntity;

public class ServiceProviderDto {
	private long service1_id;
    private long service2_id;
    private long service3_id;
    private ServiceProviderEntity serviceProvider;
	public ServiceProviderDto(ServiceProviderEntity serviceProvider, long service1_id, long service2_id,
			long service3_id) {
		super();
		this.serviceProvider = serviceProvider;
		this.service1_id = service1_id;
		this.service2_id = service2_id;
		this.service3_id = service3_id;
	}
	public ServiceProviderDto() {
		super();
	}
	public ServiceProviderEntity getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProviderEntity serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public long getService1_id() {
		return service1_id;
	}
	public void setService1_id(long service1_id) {
		this.service1_id = service1_id;
	}
	public long getService2_id() {
		return service2_id;
	}
	public void setService2_id(long service2_id) {
		this.service2_id = service2_id;
	}
	public long getService3_id() {
		return service3_id;
	}
	public void setService3_id(long service3_id) {
		this.service3_id = service3_id;
	}

    
}