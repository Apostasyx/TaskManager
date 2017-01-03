/**
 * Created by Сергей on 01.12.2016.
 */

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Samara"));

        Console cons = new Console();
        cons.menu();
        String nameXmlFile = "Solutions";
        InputOutput.marshaller(MethodsForConsole.mySolutions, nameXmlFile);

        System.exit(0);
    }
}