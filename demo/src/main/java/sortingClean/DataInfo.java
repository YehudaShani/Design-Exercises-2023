package sortingClean;


import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public class DataInfo {
    private LocalTime timer;
    private Long sumAllTime;
    private Integer sumRead;

    private String name;
    private  Long lastTime;

    public Long getLastTime() {
        return lastTime;
    }

    public String getName() {
        return name;
    }

    public DataInfo(String name) {
        this.name=name;
        sumAllTime = Long.valueOf(0);
        sumRead=0;
    }

    public Long getSumAllTime() {
        return sumAllTime;
    }

    public Integer getSumRead() {
        return sumRead;
    }

    public void start(){
        timer=LocalTime.now();
        sumRead+=1;
    }

    public void endRun(){
        Duration duration = Duration.between(timer, LocalTime.now());
        lastTime=duration.toMillis();
        sumAllTime+=lastTime;
    }
}
