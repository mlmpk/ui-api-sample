package com.example.sampleapi.model;

public class SampleData {

    int id;
    String content;
    String parameterValue;


    public SampleData(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public SampleData(int id, String content, String parameterValue) {
        this.id = id;
        this.content = content;
        this.parameterValue = parameterValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

}
