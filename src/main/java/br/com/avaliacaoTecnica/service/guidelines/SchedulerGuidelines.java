package br.com.avaliacaoTecnica.service.guidelines;

import br.com.avaliacaoTecnica.constants.Constants;
import br.com.avaliacaoTecnica.constants.StatusCode;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@EnableScheduling
@Configuration
@Component
public class SchedulerGuidelines {

    @Autowired
    private GuidelinesService service;

    @Value("${scheduler.enabled}")
    private Boolean enabled;

    @Scheduled(cron = "${scheduler.scheduler-cron-value}", zone = Constants.TIME_ZONE)
    public void checkStatusGuidelines(){
        long timeBefore = System.currentTimeMillis();
        if(enabled) {
            log.info("SchedulerGuidelines.checkStatusGuidelines - Start");

            List<GuidelinesResponseDTO> guidelines = service.getAllGuidelinesByStatus(StatusCode.RUNNING.getMessage());

            guidelines.forEach(item -> {
                try {
                    checkExpirationDate(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            log.info("SchedulerGuidelines.checkStatusGuidelines - End - took: [{}]", System.currentTimeMillis()-timeBefore);
        }
    }

    private void checkExpirationDate(GuidelinesResponseDTO item) throws Exception {
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime dateExpiration = item.getExpirationDate();
        if (dateNow.compareTo(dateExpiration) > 0){
            service.updateStatusGuidelines(item);
            service.updateApprovedAndAmountVote(item);
        }
    }
}
