package pkg1.iot1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IotRepo extends JpaRepository<IotEntity, Integer>{
	@Query(value = "select * from iot1 where name=:name",nativeQuery = true)
	public IotEntity findByName(@Param(value = "name") String name);
}
