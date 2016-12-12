/**
 * Created by Сергей on 01.12.2016.
 */
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;

public class Serialization {

    public static void serData(String file_name, Serializable obj){
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + ".xml");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e){
            System.out.println("Ошибка ввода/вывода");
            System.exit(2);
        }
    }

    public static Object deserData(String file_name) {
        Object retObject = null;
        try {
            FileInputStream fileIn = new FileInputStream(file_name + ".xml");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e){
            System.out.println("Ошибка ввода/вывода");
            System.exit(2);
        } catch (ClassNotFoundException e){
            System.out.println("Класс не найден");
            System.exit(3);
        }
        return retObject;
    }

    public static void checkFile(){
        File file = new File("\\TaskManager");
        if (file.exists() && file.isFile()) {
            MethodsForConsole.mySolutions = (ArrayList<Solutions>) Serialization.deserData("mySolutions");
        }
    }
}
