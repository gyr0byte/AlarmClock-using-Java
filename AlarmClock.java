
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class AlarmClock implements Runnable{
    private final LocalTime alarmTime;
    private final String filePath;
    AlarmClock(LocalTime alarmTime, String filePath) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
    }
    @Override
    public void run(){
        while (LocalTime.now().isBefore(alarmTime)) { 
            try {
                LocalTime now = LocalTime.now();
                Thread.sleep(1000);
                System.out.printf("\r%02d: %02d: %02d", now.getHour(), now.getMinute(), now.getSecond());
            } 
            catch (InterruptedException ex) {
               System.out.println("Thread was interrupted");
            }
        }
        System.out.println("\n*Alarm Noise*");
        playSound(filePath);
    }
    private void playSound(String filePath){
        File audioFile = new File(filePath);
        
        try (AudioInputStream audiostream = AudioSystem.getAudioInputStream(audioFile)){
            Clip clip = AudioSystem.getClip();
            
        } 
        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported format of audio");
        }
        catch(LineUnavailableException e){
            System.out.println("Audio is unavailabe");
        }
        catch(IOException e){
            System.out.println("Couldn't find the audio file");
        }
    }
}