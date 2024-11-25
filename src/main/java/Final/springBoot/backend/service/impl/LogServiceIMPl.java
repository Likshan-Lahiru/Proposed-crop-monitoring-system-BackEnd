package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.customStatusCode.SelectedErrorStatus;
import Final.springBoot.backend.dao.LogDao;
import Final.springBoot.backend.dto.impl.LogDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.impl.FieldEntity;
import Final.springBoot.backend.entity.impl.LogEntity;
import Final.springBoot.backend.entity.impl.StaffEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.exception.ItemNotFoundException;
import Final.springBoot.backend.service.LogService;
import Final.springBoot.backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LogServiceIMPl implements LogService {

    @Autowired
    private LogDao logDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveLog(LogDto logDto) {
        LogEntity save = logDao.save(mapping.toLogEntity(logDto));

        if ( save == null) {
            throw new DataPersistException();
        }
    }

    @Override
    public List<LogDto> getLogList() {
        return mapping.asLogDtoList(logDao.findAll());
    }

    @Override
    public Status getLogById(String logId) {
        if (logDao.existsById(logId)) {
            LogEntity logEntity = logDao.getOne(logId);
            return mapping.toLogDto(logEntity);
        }else {
            return new SelectedErrorStatus(2,"Field not found");
        }
    }

    @Override
    public void updateLog(String logId, LogDto logDto) {
        Optional<LogEntity> byId = logDao.findById(logId);
        if (byId.isPresent()) {
            byId.get().setLogDetails(logDto.getLogDetails());
            byId.get().setObservedImage(logDto.getObservedImage());
            byId.get().setLogdate(Date.valueOf(logDto.getLogDate()));
        }
    }

    @Override
    public void deleteLog(String logId) {
        Optional<LogEntity> byId = logDao.findById(logId);
        if (!byId.isPresent()) {
            throw new ItemNotFoundException("User with id " + logId + " not found");
        }
        logDao.deleteById(logId);
    }
}
