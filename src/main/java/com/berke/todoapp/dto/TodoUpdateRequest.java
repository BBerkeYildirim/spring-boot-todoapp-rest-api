package com.berke.todoapp.dto;

public class TodoUpdateRequest {
    private String title;
    private String content;
    private boolean status;

    public TodoUpdateRequest(String title, String content, boolean status) {
        this.title = title;
        this.content = content;
        this.status = status;
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
}
