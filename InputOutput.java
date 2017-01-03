/**
 * Created by Сергей on 01.12.2016.
 */

import java.io.FileWriter;
import java.util.*;
import java.io.*;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.extended.EncodedByteArrayConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class InputOutput{
    Solutions sol = new Solutions();
    MethodsForConsole meth = new MethodsForConsole();

    public static void marshaller(List<Solutions> object, String nameXmlFile) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias(nameXmlFile, ArrayList.class);
        xStream.processAnnotations(Solutions.class);

        String xml = xStream.toXML(object);
        saveToFile(xml, nameXmlFile);
    }

    private static void saveToFile(String xml, String nameFile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile + ".xml")));
        bufferedWriter.write(xml);
        bufferedWriter.close();
    }

    public static List<Solutions> unmarshalling(File file) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("Solutions", ArrayList.class);
        xStream.alias("Solution", Solutions.class);
        xStream.aliasField("Description", Solutions.class, "description");
        xStream.aliasField("Date", Solutions.class, "date");
        xStream.aliasField("Current Date", Solutions.class, "currentDate");
        xStream.aliasField("Phone number", Solutions.class, "phoneNumber");
        xStream.aliasField("Email", Solutions.class, "email");
        xStream.registerConverter((Converter) new EncodedByteArrayConverter());

        return (List<Solutions>) xStream.fromXML(file);
    }
}
