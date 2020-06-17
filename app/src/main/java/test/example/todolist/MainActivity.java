package test.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> tasks = new ArrayList<Task>();

        tasks.add(new Task("Go to Store"));
        tasks.add(new Task("Laundry"));
        tasks.add(new Task("Sleep"));
        tasks.add(new Task("Eat"));
        tasks.add(new Task("Finish HW"));
        tasks.add(new Task("Exercise"));
        tasks.add(new Task("Buy Clothes"));
        tasks.add(new Task("Go to Park"));
        tasks.add(new Task("Find Book"));
        tasks.add(new Task("Set up System"));
        tasks.add(new Task("Learn New Technology"));
        tasks.add(new Task("Build Application"));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        Adapter recyclerAdapter = new RecyclerAdapter(tasks, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

}