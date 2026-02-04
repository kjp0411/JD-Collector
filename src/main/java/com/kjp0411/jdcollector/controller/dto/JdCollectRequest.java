package com.kjp0411.jdcollector.controller.dto;

import java.util.List;

public class JdCollectRequest {

    private List<String> urls;

    public JdCollectRequest() {
    }

    public JdCollectRequest(List<String> urls) {
        this.urls = urls;
    }

    public  List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
