package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class KodillaUser implements TasksObservable {
    private TasksObserver observer;
    private final List<String> tasks;
    private final String name;

    public KodillaUser(String name) {
        tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observer.update(this);
    }

    @Override
    public void registerObserver(TasksObserver observer) {
        this.observer = observer;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
