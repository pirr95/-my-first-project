package ru.future.scientist.myfirstproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TaskAdapter adapter;
    private TaskGenerator generator = new TaskGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddTask.getStartIntent(this);
            startActivity(intent);
        });
    }

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        updateList();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private void initList() {
        RecyclerView rvTasks = findViewById(R.id.task);
        rvTasks.setHasFixedSize(true);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        List<Task> tasks = AppDatabase.getInstance(this).taskDao().getAll();
        adapter = new TaskAdapter(tasks, item -> {
            Toast.makeText(this, item.getDescription(), Toast.LENGTH_LONG).show();
        });
                rvTasks.setAdapter(adapter);

    }
    private void updateList() {
        List<Task> people = AppDatabase.getInstance(this).taskDao().getAll();
        adapter.update(people);
    }
}
