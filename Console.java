/**
 * Created by Сергей on 02.12.2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Console {
    MethodsForConsole meth = new MethodsForConsole();

    public void menu() throws IOException, ParseException {
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Выберите опцию:");
            System.out.println("     1. Добавить задачу");
            System.out.println("     2. Посмотреть список задач");
            System.out.println("     3. Отсрочить задачу");
            System.out.println("     4. Удалить задачу");
            System.out.println("     5. Закрыть программу");
            System.out.println("Введите номер опции: ");
            int operationNumber = Integer.parseInt(reader.readLine());
            switch (operationNumber) {
                case 1:
                    meth.addSolution();
                    break;
                case 2:
                    meth.showSolutions();
                    break;
                case 3:
                    meth.deferSolutions();
                    break;
                case 4:
                    meth.removeSolutions();
                    break;
                case 5:
                    reader.close();
                    return;
                default:
                    System.out.println("Нет такой опции! Смотри список опций.");
                    break;
            }
        }
    }
}
