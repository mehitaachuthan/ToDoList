package test.example.todolist;
import androidx.appcompat.app.AppCompatActivity;
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
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        saveButton = findViewById(R.id.save);
        taskName = findViewById(R.id.enter_task);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatabaseHelper dbHelper;
                try {
                    Task task = new Task(-1, taskName.getText().toString());
                    dbHelper = new DatabaseHelper(InsertActivity.this);
                    dbHelper.add(task);
                }
                catch(Exception e) {
                    Toast.makeText(InsertActivity.this, "Error Creating Task", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}