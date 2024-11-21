package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dto.impl.LogDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.service.LogService;

import java.util.List;

public class LogServiceIMPl implements LogService {
    @Override
    public void saveLog(LogDto logDto) {

    }

    @Override
    public List<LogDto> getLogList() {
        return List.of();
    }

    @Override
    public Status getLogById(String logId) {
        return null;
    }

    @Override
    public void updateLog(String logId, LogDto logDto) {

    }

    @Override
    public void deleteLog(String logId) {

    }
}
