package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String userName;
    private final char userSex;
    private final LocalDate dateOfBirth;
    private final int postsPublishedNumber;

    public ForumUser(final int userID, final String userName, final char userSex, final LocalDate dateOfBirth, final int postsPublishedNumber) {
        this.userID = userID;
        this.userName = userName;
        this.userSex = userSex;
        this.dateOfBirth = dateOfBirth;
        this.postsPublishedNumber = postsPublishedNumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public int getPostsPublishedNumber() {
        return postsPublishedNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsPublishedNumber=" + postsPublishedNumber +
                '}';
    }
}
