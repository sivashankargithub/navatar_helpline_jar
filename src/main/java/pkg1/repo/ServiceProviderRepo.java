package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.ServiceProviderEntity;

public interface ServiceProviderRepo extends JpaRepository<ServiceProviderEntity,Long>{
}
