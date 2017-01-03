/**
 * Created by Сергей on 01.12.2016.
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.*;
import java.io.*;

@XStreamAlias("Solutions")
public class Solutions{

    @XStreamAlias("Solution")
    private String solution;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("Date")
    private Date date;
    @XStreamAlias("Current Date")
    private Date currentDate;
    @XStreamAlias("Phone Number")
    private String phoneNumber;
    @XStreamAlias("Email")
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

    @Override
    public String toString(){
        return "Solutions{" +
                "Solution" + solution + ", " + "Description" + description + ", " + "Date" + date + ", " +
                "Current date" + currentDate + ", " + "Phone number" + phoneNumber + ", " + "Email" + email + "}";
    }
}
