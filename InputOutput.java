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

    public static void marshaller(List<Solution> object, String nameXmlFile) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias(nameXmlFile, List.class);
        xStream.processAnnotations(Solution.class);

        String xml = xStream.toXML(object);
        saveToFile(xml, nameXmlFile);
    }

    private static void saveToFile(String xml, String nameFile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile + ".xml")));
        bufferedWriter.write(xml);
        bufferedWriter.close();
    }

    public static List<Solution> unmarshalling(File file) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("SolutionList", List.class);
        xStream.alias("Solution", Solution.class);
        xStream.aliasField("Solution", Solution.class, "solution");
        xStream.aliasField("Description", Solution.class, "description");
        xStream.aliasField("Date", Solution.class, "date");
        xStream.aliasField("CurrentDate", Solution.class, "currentDate");
        xStream.aliasField("PhoneNumber", Solution.class, "phoneNumber");
        xStream.aliasField("Email", Solution.class, "email");
        xStream.registerConverter((Converter) new EncodedByteArrayConverter());

        return (ArrayList<Solution>) xStream.fromXML(file);
    }
}
