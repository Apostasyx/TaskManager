/**
 * Created by Сергей on 04.12.2016.
 */

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.io.Serializable;

public class TimerForTask extends TimerTask{
    Solutions sol = new Solutions();
    Timer timer = new Timer();

    public TimerForTask() {
    }

    private TimerForTask(Solutions sol) {
        this.sol = sol;
    }

    public void run(){
        System.out.println("\nСегодня нужно сделать: " + sol.getSolution());
    }

    public void toNotificate(Date date, Solutions sol){
        timer.schedule(new TimerForTask(sol), date);
    }
}
