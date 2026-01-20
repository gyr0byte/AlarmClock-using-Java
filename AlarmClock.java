import java.time.LocalTime;
public class AlarmClock implements Runnable{
    private final LocalTime  alarmTime;

    public AlarmClock(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }
    @Override
    public void run(){

    }
}