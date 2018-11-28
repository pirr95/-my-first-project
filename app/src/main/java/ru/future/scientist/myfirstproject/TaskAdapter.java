package ru.future.scientist.myfirstproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;
import java.util.jar.Attributes;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bind(tasks.get(position));

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class  TaskViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvTime;
        CheckBox cbCompleted;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            cbCompleted =  itemView.findViewById(R.id.cbCompleted);
        }
        public void bind(Task task){
            tvName.setText(task.getName());
            tvTime.setText(new Date(task.getTime()).toString());
            cbCompleted.setChecked(task.isCompleted());

        }
    }
}
