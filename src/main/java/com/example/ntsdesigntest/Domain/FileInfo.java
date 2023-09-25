package com.example.ntsdesigntest.Domain;

import jakarta.persistence.*;


import java.util.Date;

@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    @Column(columnDefinition = "varchar",unique = true)
    private String fileName;
    @Column(columnDefinition = "date")
    private Date fileDate;
    @Column(columnDefinition = "text")
    private String filePath;

    public FileInfo() {
    }

    public FileInfo(String fileName, Date fileDate, String filePath) {
        this.fileName = fileName;
        this.fileDate = fileDate;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }



    public String getFilePath() {
        return filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
