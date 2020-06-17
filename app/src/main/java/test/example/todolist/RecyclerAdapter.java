package test.example.todolist;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.Context;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private ArrayList<Task> tasks;
    Context context;

    public RecyclerAdapter(ArrayList<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView taskItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.taskItem = itemView.findViewById(R.id.task_name);
        }
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View layoutView = layoutInflater.inflate(R.layout.task, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.taskItem.setText(tasks.get(position).getName() + "");
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
