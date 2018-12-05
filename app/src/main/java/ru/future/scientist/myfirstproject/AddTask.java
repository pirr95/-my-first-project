package ru.future.scientist.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTask extends AppCompatActivity {


    private TextInputLayout tilName;
    private TextInputLayout tilDate;
    private TextInputLayout tilTime;
    private TaskGenerator generator = new TaskGenerator();
    private String avatarLink = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddTask.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        tilName = findViewById(R.id.tilName);
        tilDate = findViewById(R.id.tilDate);
        tilTime = findViewById(R.id.tilTime);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Task task = generator.getTask();
            tilName.getEditText().setText(task.getName());


            Date Task = new Date(task.getTime());
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy"); // e.g. 24.10.2018
            tilDate.getEditText().setText(formatDate.format(Task));
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm"); // e.g. 15:46
            tilTime.getEditText().setText(formatTime.format(Task));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_task, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            String name = tilName.getEditText().getText().toString();


            String dateTime = tilDate.getEditText().getText().toString() + " " + tilTime.getEditText().getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm"); // e.g. 24.10.2018 15:46
            long task;
            try {
                task = format.parse(dateTime).getTime();
            } catch (ParseException e) {
                task = new Date().getTime();
                Log.e("AddPersonActivity", "Date parse error", e);
            }

        }
    }


    }
}
