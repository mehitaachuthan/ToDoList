package test.example.todolist;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity{

    private EditText taskName;
    private Button updateButton;
    private Button deleteButton;
    private String taskNameToUpdate;
    private int taskID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        getSupportActionBar().setTitle("Update Task");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        taskName = findViewById(R.id.task_name_update);
        updateButton = findViewById(R.id.update_button);
        deleteButton = findViewById(R.id.delete_button);

        Bundle data = getIntent().getExtras();
        taskID = data.getInt("Task_ID");
        taskNameToUpdate = data.getString("Task_Name");

        taskName.setText(taskNameToUpdate);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                DatabaseHelper dbHelper;
                try {
                    dbHelper = new DatabaseHelper(UpdateActivity.this);
                    dbHelper.deleteTask(taskID);
                    finish();
                }
                catch(Exception e) {
                    Toast.makeText(UpdateActivity.this, "Could not delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
