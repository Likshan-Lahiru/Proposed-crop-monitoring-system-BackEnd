package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.LogDto;
import Final.springBoot.backend.dto.status.Status;

import java.util.List;

public interface LogService {
    void saveLog(LogDto logDto);
    List<LogDto> getLogList();
    Status getLogById(String logId);
    void updateLog(String logId, LogDto logDto);
    void deleteLog(String logId);
    String generateLogID();
}
