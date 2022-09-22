package software.sigma.logsforuniversityapi;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import software.sigma.logsforuniversityapi.entity.LogRecord;
import software.sigma.logsforuniversityapi.entity.Parameter;
import software.sigma.logsforuniversityapi.repository.LogRepository;
import software.sigma.logsforuniversityapi.repository.ParamRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Receiver {
    private final LogRepository logRepository;
    private final ParamRepository paramRepository;

    @KafkaListener(topics = "logs", groupId = "message_group_id")
    public void saveLogs(Map<String, Object> infoForLogs) {
        String principal = (String) infoForLogs.get("principal");
        String method = (String) infoForLogs.get("method");
        List<Parameter> parameters = ((List<String>) infoForLogs.get("params"))
                .stream()
                .map(content -> {
                    Parameter parameter = new Parameter();
                    parameter.setContent(content);
                    return paramRepository.save(parameter);
                })
                .collect(Collectors.toList());
        Date date = new Date((Long) infoForLogs.get("date"));
        logRepository.save(new LogRecord(null, principal, method, parameters, date));
    }
}