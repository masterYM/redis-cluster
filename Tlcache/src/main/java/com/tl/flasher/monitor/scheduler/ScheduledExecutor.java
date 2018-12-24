package com.tl.flasher.monitor.scheduler;

import com.tl.flasher.monitor.job.MonitorExecutorJob;

import java.util.Map;
import java.util.concurrent.*;

public class ScheduledExecutor implements ScheduledService {
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    @Override
    public void startJob(Map<String,Object> context,int intervalInSeconds) {
        MonitorExecutorJob job = new MonitorExecutorJob(context);
        service.scheduleAtFixedRate(job,0,intervalInSeconds,TimeUnit.SECONDS);
    }

    @Override
    public void shutdown() {
        if(null != service){
            service.shutdown();
        }
        service = null;
    }

}
