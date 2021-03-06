/**
 * Created by Сергей on 01.12.2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MethodsForConsole {
    static List<Solution> mySolutions = new ArrayList<Solution>();
    TimerForTask timer = new TimerForTask();

    public void addSolution() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя задачи: ");
        String solution = reader.readLine();
        System.out.println("Введите описание задачи: ");
        String description = reader.readLine();
        System.out.println("Введите дату задачи(в формате дд:мм:гггг чч:мм:сс): ");
        SimpleDateFormat preDate = new SimpleDateFormat("dd:MM:yyyy hh:mm:ss");
        Date date = preDate.parse(reader.readLine());
        System.out.println("Введите контактные данные");
        System.out.println("Телефонный номер: ");
        String phoneNumber = reader.readLine();
        System.out.println("Введите email: ");
        String email = reader.readLine();
        Date currentDate = new Date();
        System.out.println("Время добавления задачи: " + currentDate);
        Solution sol = new Solution(solution, description, date, currentDate, phoneNumber, email);
        timer.toNotificate(date, sol);
        mySolutions.add(sol);
        //reader.close();
    }

    public void showSolutions() {
        System.out.println("Показываю список задач: ");
        for(Solution sol : mySolutions){
            System.out.println(sol.getSolution() + "\n" + sol.getDescription() + "\n" + sol.getDate() + "\n" +
                    sol.getCurrentDate() + "\n" + sol.getPhoneNumber() + "\n" + sol.getEmail());
        }
    }

    public void deferSolutions() throws IOException, ParseException {
        System.out.print("Введите номер задачи: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(reader.readLine());
        System.out.print("Введите дату задачи(в формате дд/мм/гггг): ");
        SimpleDateFormat preDate = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = preDate.parse(reader.readLine());
        executionDeferSolution(index, newDate);
        //reader.close();
    }

    public void removeSolutions() throws IOException {
        System.out.println("Удаляю задачу по номеру.");
        System.out.print("Введите номер удяляемой задачи: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(reader.readLine());
        removeSolutionByIndex(index);
        //reader.close();
    }

    public void removeSolutionByIndex(int index){
        mySolutions.remove(index);
    }

    public void executionDeferSolution(int index, Date newDate){
        mySolutions.get(index).setDate(newDate);
    }
}
