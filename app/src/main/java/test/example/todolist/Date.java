package test.example.todolist;
import java.lang.String;
import androidx.annotation.NonNull;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return  day;
    }

    @NonNull
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
