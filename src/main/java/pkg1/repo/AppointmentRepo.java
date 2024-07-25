package pkg1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.AppointmentEntity;



public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Long>{
	@Query(value = "select * from appointment where customer_id=:cid", nativeQuery = true)
	List<AppointmentEntity>findAppointByCustId(@Param(value = "cid") long cid);
	
	@Query(value = "select * from appointment where service_provider_id=:spid", nativeQuery = true)
	List<AppointmentEntity>findAppointBySPId(@Param(value = "spid") long spid);
	
	@Query(value = "select * from appointment where customer_id=:cid and service_provider_id=:spid", nativeQuery = true)
	List<AppointmentEntity> findAppointByCustIdandSPid(@Param(value = "cid") long cid, @Param(value = "spid") long spid);
}
