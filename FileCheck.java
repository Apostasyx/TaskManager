/**
 * Created by Сергей on 03.01.2017.
 */
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileCheck {

    private static final String filename = "D:\\IntelliJ IDEA Community Edition 2016.2.4\\TaskManager\\Solutions.xml";

    public static void checkFile(String filename) throws IOException {

        final File file = new File(filename);
        String nameXmlFile = "Solutions";

        if (file.exists()) {
            System.out.println("Загружаем файл с событиями...");
            List<Solutions> solutions = InputOutput.unmarshalling(new File(nameXmlFile.concat(".xml")));
        }
    }
}
