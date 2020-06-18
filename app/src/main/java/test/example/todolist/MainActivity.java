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

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Adapter recyclerAdapter;
    ArrayList<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<Task>();
        tasks.add(new Task(1, "Go to Store"));
        /*tasks.add(new Task(2, "Laundry"));
        tasks.add(new Task(3, "Sleep"));
        tasks.add(new Task(4, "Eat"));
        tasks.add(new Task(5, "Finish HW"));
        tasks.add(new Task(6, "Exercise"));
        tasks.add(new Task(7, "Buy Clothes"));
        tasks.add(new Task(8, "Go to Park"));
        tasks.add(new Task(9, "Find Book"));
        tasks.add(new Task(10, "Set up System"));
        tasks.add(new Task(11, "Learn something"));
        tasks.add(new Task(12, "Build Application")); */

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        recyclerAdapter = new RecyclerAdapter(tasks, this);
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
}