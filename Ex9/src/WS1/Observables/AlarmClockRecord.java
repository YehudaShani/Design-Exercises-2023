package WS1.Observables;

public class AlarmClockRecord {

    int interval;
    int remainingTime;
    AlarmListener alarmListener;
    public AlarmClockRecord(int interval,AlarmListener alarmListener) {
        this.alarmListener=alarmListener;
        this.interval = interval;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setAlarmListener(AlarmListener alarmListener) {
        this.alarmListener = alarmListener;
    }

    public AlarmListener getAlarmListener() {
        return alarmListener;
    }
}
