package Final.springBoot.backend.service.impl;


import Final.springBoot.backend.customStatusCode.SelectedFieldErrorStatus;
import Final.springBoot.backend.dao.FieldDao;
import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.status.FieldStatus;
import Final.springBoot.backend.entity.impl.FieldEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.FieldService;
import Final.springBoot.backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class FieldServiceIMPL implements FieldService {

    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveField(FieldDto fieldDto) {

        FieldEntity save = fieldDao.save(mapping.toFieldEntity(fieldDto));

        if ( save == null) {
            throw new DataPersistException();
        }

    }

    @Override
    public List<FieldDto> getFieldList() {
        return mapping.asFieldDtoList(fieldDao.findAll());
    }

    @Override
    public FieldStatus getFieldById(String fieldId) {
        if (fieldDao.existsById(fieldId)) {
            FieldEntity fieldEntity = fieldDao.getOne(fieldId);
            return mapping.toFieldDto(fieldEntity);
        }else {
            return new SelectedFieldErrorStatus(2,"Field not found");
        }
    }

    @Override
    public void updateField(String fieldId, FieldDto FieldDto) {
        Optional<FieldEntity> byId = fieldDao.findById(fieldId);
        if (byId.isPresent()) {
            byId.get().setFieldName(FieldDto.getFieldName());
            byId.get().setFieldLocation(FieldDto.getFieldLocation());
            byId.get().setFieldSize(FieldDto.getFieldSize());
            byId.get().setImage1(FieldDto.getImage1());
            byId.get().setImage2(FieldDto.getImage2());
        }
    }

    @Override
    public void deleteField(String fieldId) {

    }


}
