package test.example.todolist;
import java.lang.String;
import androidx.annotation.NonNull;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    @NonNull
    public String toString() {
        return hour + ":" + minute;
    }
}
