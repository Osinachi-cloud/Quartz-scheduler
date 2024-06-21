package com.cymark.quartz_scheduler.services;

import com.cymark.quartz_scheduler.commonUtils.CommonUtils;
import com.cymark.quartz_scheduler.jobs.FirstJob;
import com.cymark.quartz_scheduler.model.TriggerInfo;
import com.cymark.quartz_scheduler.scheduler.MainScheduler;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ScheduleForever {

    private final MainScheduler scheduler;
    private final CommonUtils commonUtils;

    // running forever
    @PostConstruct
    public void init(){
        TriggerInfo info = commonUtils.getTriggerInfo(3,true, 1000L, 1000L, "Success");
        scheduler.scheduleJob(FirstJob.class, info);
    }

    // running based on cron expression
    @PostConstruct
    public void init1(){
        scheduler.scheduleJob(FirstJob.class, "0/2 * * * * ?");
    }


}
