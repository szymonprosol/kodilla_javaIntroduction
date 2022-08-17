package com.kodilla.patterns2.observer.homework;

public interface TasksObservable {
    void registerObserver(TasksObserver observer);
    void notifyObservers();
}
