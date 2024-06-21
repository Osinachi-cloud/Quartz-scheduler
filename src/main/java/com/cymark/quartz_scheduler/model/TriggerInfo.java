package com.cymark.quartz_scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TriggerInfo implements Serializable {
    // how many times you want to trigger that job
    private int triggerCount;

    // running infinitely
    private boolean isRunForever;

    // time interval between two processes
    private Long timeInterval;

    // when do you want you project to start running
    private Long initialOffSet;

    // any info you may want to store
    private String info;


}
