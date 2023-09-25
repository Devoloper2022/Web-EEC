package com.example.ntsdesigntest.dto;

import org.springframework.core.io.Resource;

import java.util.Date;
public class DownloadResponse {
    private String name;
    private Date data;
    private String path;
    private Resource resource;


    public DownloadResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
