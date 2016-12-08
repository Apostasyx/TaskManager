/**
 * Created by Сергей on 04.12.2016.
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class TimerForTask {
    Date currentDate = new Date();

    public void toNotificate(long ms, Solutions sol){

    }

    public long getDifferenceDateInMs(Date taskDate){
        long difference = currentDate.getTime() - taskDate.getTime();
        return difference;
    }

    public long parseDateToMs(Date date) {
        long ms = date.getTime();
        return ms;
    }
}
