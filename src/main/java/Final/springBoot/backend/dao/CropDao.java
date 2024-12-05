package Final.springBoot.backend.dao;

import Final.springBoot.backend.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropDao extends JpaRepository<CropEntity,String> {
    List<CropEntity> findByCropCategory(String cropCategory);
}
