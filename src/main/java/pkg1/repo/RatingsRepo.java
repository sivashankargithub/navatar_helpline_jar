package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.RatingsEntity;

public interface RatingsRepo extends JpaRepository<RatingsEntity, Long>{
}
