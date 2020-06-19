package test.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.content.Intent;
import java.util.ArrayList;
import android.view.Menu;
import android.widget.Toast;
import android.util.Log;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnTaskClickListener{

    Adapter recyclerAdapter;
    RecyclerView recyclerView;
    DatabaseHelper dbHelper;
    ArrayList<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);

        dbHelper = new DatabaseHelper(MainActivity.this);
        update();
    }

    protected void onResume() {
        // Set Recycler view in resume since must pass through onResume when return from
        // the insert activity
        super.onResume();
        update();
    }

    public void update() {
        tasks = dbHelper.getAll();

        recyclerAdapter = new RecyclerAdapter(tasks, this, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent intent = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void onTaskClick(int position) {
        Toast.makeText(this, "Clicked " + tasks.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}