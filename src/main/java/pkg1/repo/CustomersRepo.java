package pkg1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.CustomersEntity;

public interface CustomersRepo extends JpaRepository<CustomersEntity, Long> {
}