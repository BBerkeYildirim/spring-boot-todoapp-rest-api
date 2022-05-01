package com.berke.todoapp.dto;

public class TodoCreateRequest {

    private String title;
    private String content;
    private boolean status;
    private int userId;

    public TodoCreateRequest(String title, String content, boolean status, int userId) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
