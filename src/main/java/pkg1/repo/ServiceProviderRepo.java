package pkg1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.ServiceProviderEntity;

public interface ServiceProviderRepo extends JpaRepository<ServiceProviderEntity,Long>{

	@Query(value = "select * from service_provider where service1_id=:id or service2_id=id or service3_id=:id", nativeQuery = true)
	List<ServiceProviderEntity>findServiceProviderByServiceId(@Param(value = "id") int id);
}
