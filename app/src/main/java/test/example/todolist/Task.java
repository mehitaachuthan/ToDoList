package test.example.todolist;
import java.lang.String;

public class Task {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getName() {
        return taskName;
    }
}
