package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.ServicesEntity;

public interface ServicesRepo extends JpaRepository<ServicesEntity, Long>{
}
