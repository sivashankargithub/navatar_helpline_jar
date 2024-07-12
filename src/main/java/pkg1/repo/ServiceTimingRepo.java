package pkg1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.ServiceTimingEntity;

public interface ServiceTimingRepo extends JpaRepository<ServiceTimingEntity, Long>{
	@Query(value = "select * from service_timing where service_provider_id=:id", nativeQuery = true)
	List<ServiceTimingEntity> findServiceProviderTimingsByServiceProviderId(@Param(value = "id") int id);
}