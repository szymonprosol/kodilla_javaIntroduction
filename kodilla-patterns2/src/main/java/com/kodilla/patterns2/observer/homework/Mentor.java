package com.kodilla.patterns2.observer.homework;

public class Mentor implements TasksObserver {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(KodillaUser kodillaUser) {
        System.out.println(username + ": New tasks from the student " + kodillaUser.getName() + "\n" +
                " (total: " + kodillaUser.getTasks().size() + " tasks)");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
