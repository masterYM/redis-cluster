package com.tl.flasher.monitor.scheduler;

import java.util.Map;

public interface ScheduledService {
    void startJob(Map<String,Object> context,int intervalInSeconds);
    void shutdown();
}
