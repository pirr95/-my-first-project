package ru.future.scientist.myfirstproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TaskGenerator {

    private static final String[] names = new String[]{"привет", "привет привет "};
    private static final String[] descriptions = new String[]{"привет", "привет привет "};

    private Random random = new Random();

    public Task getTask() {
        final String name = names[random.nextInt(names.length)];
        final String description = descriptions[random.nextInt(descriptions.length)];
        final long time = new Date().getTime();
        final boolean completed = random.nextBoolean();
        return new Task(name, description, time, completed);
    }

    public List<Task> getTask(final int count) {
        List<Task> task = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            task.add(getTask());
        }
        return task;
    }
}
