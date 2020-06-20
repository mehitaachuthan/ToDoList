package test.example.todolist;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.Toast;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private ArrayList<Task> tasks;
    private Context context;
    private OnTaskClickListener taskListener;

    public RecyclerAdapter(ArrayList<Task> tasks, Context context, OnTaskClickListener taskListener) {
        this.tasks = tasks;
        this.context = context;
        this.taskListener = taskListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView taskItem;
        public OnTaskClickListener taskClickListener;

        public MyViewHolder(View itemView, OnTaskClickListener taskClickListener) {
            super(itemView);
            this.taskItem = itemView.findViewById(R.id.task_name);
            this.taskClickListener = taskClickListener;
            itemView.setOnClickListener(MyViewHolder.this);
        }

        public void onClick(View view) {
            taskClickListener.onTaskClick(getLayoutPosition());
        }
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View layoutView = layoutInflater.inflate(R.layout.task, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView, taskListener);
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
