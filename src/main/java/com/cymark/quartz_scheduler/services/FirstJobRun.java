package com.cymark.quartz_scheduler.services;

import com.cymark.quartz_scheduler.commonUtils.CommonUtils;
import com.cymark.quartz_scheduler.jobs.FirstJob;
import com.cymark.quartz_scheduler.model.TriggerInfo;
import com.cymark.quartz_scheduler.scheduler.MainScheduler;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FirstJobRun {

    private final MainScheduler scheduler;
    private final CommonUtils commonUtils;

//    @PostConstruct
//    public void init(){
//
//        TriggerInfo info = commonUtils.getTriggerInfo(3,false, 1000L, 1000L, "Success");
//        scheduler.scheduleJob(FirstJob.class, info);
//    }


}
