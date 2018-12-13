package ru.future.scientist.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_TASK_ID = "ru.future.scientist.myfirstproject.extras.EXTRA_TASK_ID";


    public static Intent getStartIntent(Context context, long taskId) {
        return new Intent(context, TaskDetailsActivity.class).putExtra(EXTRA_TASK_ID, taskId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        initUi();

    }

    private void initUi() {

        TextInputLayout tvName = findViewById(R.id.tilName);
        TextInputLayout tvDescription = findViewById(R.id.tilDescription);
        TextInputLayout tvDate = findViewById(R.id.tilDate);
        TextInputLayout tvTime = findViewById(R.id.tilTime);

        final long taskId = getIntent().getLongExtra(EXTRA_TASK_ID, 0);
        final Task task = AppDatabase.getInstance(this).taskDao().getById(taskId);

        tvName.getEditText().setText(task.getName());
        tvDescription.getEditText().setText(task.getDescription());

        SimpleDateFormat formatDate = new SimpleDateFormat("dd MMMM yyyy"); // e.g. 24 October 2018
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm"); // e.g. 15:46
        Date date = new Date(task.getTime());
        tvDate.getEditText().setText(formatDate.format(date));
        tvTime.getEditText().setText(formatTime.format(date));
    }


}
