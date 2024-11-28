package Final.springBoot.backend.dao;

import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.entity.impl.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffDao extends JpaRepository<StaffEntity,String> {

}
