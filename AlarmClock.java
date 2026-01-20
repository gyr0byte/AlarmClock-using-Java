
import java.time.LocalTime;
public class AlarmClock implements Runnable{
    private final LocalTime alarmTime;

    AlarmClock(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }
    @Override
    public void run(){
        while (LocalTime.now().isBefore(alarmTime)) { 
            try {
                Thread.sleep(1000);
                System.out.println(LocalTime.now());
            } catch (InterruptedException ex) {
               System.out.println("Thread was interrupted");
            }
        }
    }
}