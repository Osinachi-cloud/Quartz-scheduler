package com.cymark.quartz_scheduler.commonUtils;

import com.cymark.quartz_scheduler.model.TriggerInfo;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommonUtils {

    public JobDetail getJobDetail(Class className, TriggerInfo info){

        JobDataMap jobData = new JobDataMap();
        jobData.put(className.getSimpleName(), info);

        return JobBuilder.newJob(className)
                .withIdentity(className.getSimpleName(), "group")
                // in case you need to store in db
                .storeDurably(true)
                .requestRecovery(true)
                // ends here
                .setJobData(jobData)
                .build();
    }

    // for cron expression
    public JobDetail getJobDetail(Class className){
        return JobBuilder.newJob(className)
                .withIdentity(className.getSimpleName(), "group1")
//                .storeDurably(false)
                .build();
    }

    // the trigger takes in some details: interval, start time, repetition count
    public Trigger getTriggerInfoOfJob(Class className, TriggerInfo info){

        // takes in the time interval in Long
        SimpleScheduleBuilder scheduler = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMilliseconds(info.getTimeInterval());

        if(info.isRunForever()){
            scheduler.repeatForever();
        }else {
            scheduler.withRepeatCount(info.getTriggerCount());
        }

        return TriggerBuilder.newTrigger()
                // starts from when the app starts and the initial offset time passed
                .startAt(new Date(System.currentTimeMillis() + info.getInitialOffSet()))
                .withSchedule(scheduler)
                .build();
    }

    // for cron expression
    public Trigger getTriggerByCronExpression(Class className,String expression){
        return TriggerBuilder
                .newTrigger()
                .withIdentity(className.getSimpleName())
                .withSchedule(CronScheduleBuilder.cronSchedule(expression))
                .build();
    }

    public TriggerInfo getTriggerInfo(int triggerCount, boolean isRunForever, Long timeInterval, Long initialOffSet,String info){
        TriggerInfo triggerInfo = new TriggerInfo();
        triggerInfo.setRunForever(isRunForever);
        triggerInfo.setTriggerCount(triggerCount);
        triggerInfo.setTimeInterval(timeInterval);
        triggerInfo.setInitialOffSet(initialOffSet);
        triggerInfo.setInfo(info);

        return triggerInfo;
    }


}
