package com.mahagan.model;

public class IOTDevice {

    private int Id;
    private String deviceName;
    private String deviceNameLocation;
    private String deviceFunction;

    // Getters and setter


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNameLocation() {
        return deviceNameLocation;
    }

    public void setDeviceNameLocation(String deviceNameLocation) {
        this.deviceNameLocation = deviceNameLocation;
    }

    public String getDeviceFunction() {
        return deviceFunction;
    }

    public void setDeviceFunction(String deviceFunction) {
        this.deviceFunction = deviceFunction;
    }

    //Parameterized Constructor


    public IOTDevice(int id, String deviceName, String deviceNameLocation, String deviceFunction) {
        Id = id;
        this.deviceName = deviceName;
        this.deviceNameLocation = deviceNameLocation;
        this.deviceFunction = deviceFunction;

    }

    //defualt constructor

    public IOTDevice() {
    }

    //toString Method

    @Override
    public String toString() {
        return "IOTDevice{" +
                "Id=" + Id +
                ", deviceName='" + deviceName + '\'' +
                ", deviceNameLocation='" + deviceNameLocation + '\'' +
                ", deviceFunction='" + deviceFunction + '\'' +
                '}';
    }
}

