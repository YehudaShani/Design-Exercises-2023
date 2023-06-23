package WS1.Observables;

import WS1.Observables.AlarmClockRecord;
import WS1.Observables.AlarmListener;

import java.util.ArrayList;

public class AlarmClock
{
    public final int CLOCK_INTERVAL_MILLIS = 100;
    protected static AlarmClock instance = null;
    private ArrayList<AlarmClockRecord> itsAlarmClockRecords = new ArrayList();

    protected AlarmClock() {}
    public static AlarmClock theInstance()
    {
        if(null==instance)
            instance = new AlarmClock();
        return instance;
    }

    protected void tic(){
        for(AlarmClockRecord record : itsAlarmClockRecords){
            if (record.getRemainingTime()-CLOCK_INTERVAL_MILLIS<=0){
                record.getAlarmListener().wakeup();
                record.setRemainingTime(record.getInterval());
            }
            else record.
        }

    }

    public void register(int interval, AlarmListener pal) {
        itsAlarmClockRecords.add(new AlarmClockRecord(interval,pal));
    }


}

