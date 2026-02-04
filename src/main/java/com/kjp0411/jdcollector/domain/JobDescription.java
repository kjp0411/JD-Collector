package com.kjp0411.jdcollector.domain;

public class JobDescription {

    private String title;
    private String company;
    private String content;
    private String sourceUrl;

    public JobDescription(String title, String company, String content, String sourceUrl) {
        this.title = title;
        this.company = company;
        this.content = content;
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getContent() {
        return content;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }
}
