/**
 * Created by Сергей on 01.12.2016.
 */

import java.util.*;
import java.io.*;

public class Solutions implements Serializable{
    private String solution;
    private String description;
    private Date date;
    private Date currentDate;
    private String phoneNumber;
    private String email;

    public Solutions(){

    }

    public Solutions(String solution, String description, Date date, Date currentDate, String phoneNumber, String email){
        this.solution = solution;
        this.description = description;
        this.date = date;
        this.currentDate = currentDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getSolution() {
        return solution;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setDate(Date newDate) {
        this.date =  newDate;
    }
}
