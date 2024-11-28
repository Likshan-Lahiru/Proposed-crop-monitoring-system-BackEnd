package Final.springBoot.backend.dao;

import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.entity.impl.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldDao extends JpaRepository<FieldEntity,String> {


}
