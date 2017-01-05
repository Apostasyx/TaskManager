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

    public static void marshaller(List<Solutions> object, String nameXmlFile) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias(nameXmlFile, List.class);
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
        xStream.alias("mySolutions", List.class);
        xStream.alias("Solutions", Solutions.class);
        xStream.aliasField("Solution", Solutions.class, "solution");
        xStream.aliasField("Description", Solutions.class, "description");
        xStream.aliasField("Date", Solutions.class, "date");
        xStream.aliasField("CurrentDate", Solutions.class, "currentDate");
        xStream.aliasField("PhoneNumber", Solutions.class, "phoneNumber");
        xStream.aliasField("Email", Solutions.class, "email");
        xStream.registerConverter((Converter) new EncodedByteArrayConverter());

        return (ArrayList<Solutions>) xStream.fromXML(file);
    }
}
