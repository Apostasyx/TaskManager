/**
 * Created by Сергей on 04.12.2016.
 */

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerForTask extends TimerTask{
    Solution sol = new Solution();
    Timer timer = new Timer();

    public TimerForTask() {
    }

    private TimerForTask(Solution sol) {
        this.sol = sol;
    }

    public void run(){
        System.out.println("\nСегодня нужно сделать: " + sol.getSolution());
    }

    public void toNotificate(Date date, Solution sol){
        timer.schedule(new TimerForTask(sol), date);
    }
}
