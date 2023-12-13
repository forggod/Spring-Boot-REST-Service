package com.rpcrest.SpringBootRestServiseRPC;

import org.springframework.beans.factory.annotation.Value;

public class Statistic {
    private String applicationName = "rest-service-application";
    private String applicationVersion = "1.0 latest";
    private String address = "http://localhost:8080/";
    private int objectsCount;

    public Statistic() {
        CarRequest carRequest = new CarRequest();
        this.objectsCount = carRequest.getCarsShowroomCount();
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getObjectsCount() {
        return objectsCount;
    }

    public void setObjectsCount(int objectsCount) {
        this.objectsCount = objectsCount;
    }
}