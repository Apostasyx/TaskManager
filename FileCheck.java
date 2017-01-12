/**
 * Created by Сергей on 03.01.2017.
 */
import java.io.File;
import java.io.IOException;

public class FileCheck {

    private static final String filename = "D:\\IntelliJ IDEA Community Edition 2016.2.4\\TaskManager\\SolutionList.xml";

    public static void checkFile() throws IOException {

        final File file = new File(filename);
        String nameXmlFile = "SolutionList";

        if (file.exists()) {
            System.out.println("Загружаем файл с событиями...");
            MethodsForConsole.mySolutions = InputOutput.unmarshalling(new File(nameXmlFile.concat(".xml")));
        } else {
            System.out.println("xml Файл отсутствует!");
        }
    }
}
