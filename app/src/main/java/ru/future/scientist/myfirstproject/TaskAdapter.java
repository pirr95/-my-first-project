package ru.future.scientist.myfirstproject;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.jar.Attributes;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter {

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
        public void bild(Task task){
            tvName.setText(task.getName());
            tvTime.setText(task.getName());
            cbCompleted.setChecked(task.isCompleted());

        }
    }
}
