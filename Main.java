/**
 * Created by Сергей on 01.12.2016.
 */

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Serialization.checkFile();
        Console cons = new Console();
        /*TimerForTask test = new TimerForTask();
        Date date = new Date();
        long ms = test.parseDateToMs(date);
        System.out.println(ms);*/
        cons.menu();
        Serialization.serData("mySolutions", (Serializable) MethodsForConsole.mySolutions);
    }
}