package pkg1.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.ServiceTimingEntity;

public interface ServiceTimingRepo extends JpaRepository<ServiceTimingEntity, Long>{
	@Query(value = "select * from service_timing where service_provider_id=:id", nativeQuery = true)
	Optional<ServiceTimingEntity> findServiceProviderTimingsByServiceProviderId(@Param(value = "id") long id);
	
	@Query(value = "select * from service_timing where service_provider_id=:id and service_day=:day", nativeQuery = true)
	Optional<ServiceTimingEntity> findSPTimingsBySPId(@Param(value = "id") long id, @Param(value = "day") String day);
}