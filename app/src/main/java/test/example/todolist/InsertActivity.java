package test.example.todolist;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity{
    Button saveButton;
    EditText taskName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);

        getSupportActionBar().setTitle("Add New Task");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saveButton = findViewById(R.id.save);
        taskName = findViewById(R.id.enter_task);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatabaseHelper dbHelper;
                boolean success;
                try {
                    dbHelper = new DatabaseHelper(InsertActivity.this);
                    success = dbHelper.addTask(new Task(-1, taskName.getText().toString()));
                    if(!success)
                        Toast.makeText(InsertActivity.this, "Duplicate task", Toast.LENGTH_SHORT).show();
                    else
                        finish();
                }
                catch(Exception e) {
                    Toast.makeText(InsertActivity.this, "Invalid Task", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}