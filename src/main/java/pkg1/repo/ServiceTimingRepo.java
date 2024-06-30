package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.ServiceTimingEntity;

public interface ServiceTimingRepo extends JpaRepository<ServiceTimingEntity, Long>{
}