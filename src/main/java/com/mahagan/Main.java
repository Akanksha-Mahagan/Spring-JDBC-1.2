package com.mahagan;

import com.mahagan.config.ApplicationConfig;
import com.mahagan.dao.IOTDevice;
import com.mahagan.dao.IOTDeviceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationConfig.class);
        IOTDevice iotDevice = applicationContext.getBean(IOTDevice.class);

        System.out.println("List of device is:");
        for(com.mahagan.model.IOTDevice iotDevice1:iotDevice.getAllDevice()){
            System.out.println(iotDevice1);
        }

        System.out.println("\nGet Device of ID 3:");

        //========================================================

        com.mahagan.model.IOTDevice deviceBYId =iotDevice.getDeviceById(2);
        System.out.println(deviceBYId);

        //====================================================================
        System.out.println("\nCreated IOT device is:");

        com.mahagan.model.IOTDevice device = new com.mahagan.model.IOTDevice(4,"Modbus","Pune","robotic");
        System.out.println(device);
        iotDevice.createIotDevice(device);

        //=====================================================================

        System.out.println("\nList of Person is:");
        for(com.mahagan.model.IOTDevice device1 : iotDevice.getAllDevice()){
            System.out.println(device1);
        }

        //====================================================================

        System.out.println("\nDelete device by id:");
        iotDevice.deleteDevice(deviceBYId);


        //-=============================================================

        System.out.println("\nUpdate:");

        com.mahagan.model.IOTDevice ddevice =iotDevice.getDeviceById(1);

        ddevice.setDeviceName("IOT");
        ddevice.setDeviceNameLocation("PPune1");
        ddevice.setDeviceFunction("Robotr");
        iotDevice.updateDevice(ddevice);

        System.out.println("Device Updated");

        //===============================================================
        System.out.println("List of device is:");
        for(com.mahagan.model.IOTDevice iotDeviceNew :iotDevice.getAllDevice()){
            System.out.println(iotDeviceNew);
        }
        applicationContext.close();
    }

}