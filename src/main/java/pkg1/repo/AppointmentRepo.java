package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.AppointmentEntity;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Long>{
}
