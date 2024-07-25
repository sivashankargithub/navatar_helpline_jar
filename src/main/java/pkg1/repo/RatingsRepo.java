package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.RatingsEntity;

public interface RatingsRepo extends JpaRepository<RatingsEntity, Long>{
	@Query(value = "select * from ratings where appointment_id=:apid", nativeQuery = true)
	public RatingsEntity findRatingByApId(@Param(value = "apid") long apid);
	
}
