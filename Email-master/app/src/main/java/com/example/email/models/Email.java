package com.example.email.models;

import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class Email {
    private String sender;
    private String title;
    private String content;
    private String time;
    private int color;

    public Email(String sender, String title, String content, String time) {
        this.sender = sender;
        this.title = title;
        this.content = content;
        this.time = time;
        Random generator = new Random();
        this.color = generator.nextInt(4);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getFirstChar(){
        return String.valueOf(sender.charAt(0));
    }
}
