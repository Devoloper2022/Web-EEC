package com.example.ntsdesigntest.Domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MyLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    @Column(columnDefinition = "varchar")
    private String fileName;
    @Column(columnDefinition = "date")
    private Date date;
    @Column(columnDefinition = "text")
    private String message;

    public MyLogger(String fileName, Date date, String message) {
        this.fileName = fileName;
        this.date = date;
        this.message = message;
    }

    public MyLogger() {
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
