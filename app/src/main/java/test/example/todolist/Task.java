package test.example.todolist;
import java.lang.String;

public class Task {
    private int taskID;
    private String taskName;

    public Task(int taskID, String taskName) {
        this.taskID = taskID;
        this.taskName = taskName;
    }

    public int getTaskID() { return taskID; }
    public String getName() {
        return taskName;
    }
}
