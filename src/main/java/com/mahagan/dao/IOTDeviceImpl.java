package com.mahagan.dao;

import com.mahagan.model.IOTDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class IOTDeviceImpl implements IOTDevice {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public IOTDeviceImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    private final String SQL_Find_Device = "select * from iotdevice where id= ?";
    private final String SQL_Delete_Device = "delete from iotdevice where id= ?";
    private final String SQL_Update_Device = "update iotdevice set deviceName= ?,deviceNameLocation= ?,deviceFunction= ? where id= ?";
    private final String SQL_Get_All_Device = "select * from iotdevice";
    private final String SQL_Insert_Device = "insert into iotdevice(id,deviceName,deviceNameLocation,deviceFunction) value(?,?,?,?)";

    // this is to execute logic of by if in db, it will get respective records for user

    public com.mahagan.model.IOTDevice getDeviceById(int Id) {

        return (com.mahagan.model.IOTDevice) jdbcTemplate.queryForObject(SQL_Find_Device, new Object[]{Id}, new IOTDeviceMapper());
    }

    //method to get All devices from db

    public List<com.mahagan.model.IOTDevice> getAllDevice() {
        return jdbcTemplate.query(SQL_Get_All_Device, new IOTDeviceMapper());
    }

    //method to delete record from db by particular id

    public int deleteDevice(com.mahagan.model.IOTDevice iotDevice) {
        return jdbcTemplate.update(SQL_Delete_Device, iotDevice.getId()) ;
    }

    public int updateDevice(com.mahagan.model.IOTDevice iotDevice) {
        return jdbcTemplate.update(SQL_Update_Device, iotDevice.getDeviceName(),iotDevice.getDeviceNameLocation(),
                iotDevice.getDeviceFunction(),iotDevice.getId());
    }
    //method to create IOT device

    public int createIotDevice(com.mahagan.model.IOTDevice iotDevice) {
        return jdbcTemplate.update(SQL_Insert_Device, iotDevice.getId(),
                iotDevice.getDeviceName(), iotDevice.getDeviceNameLocation(), iotDevice.getDeviceFunction());
    }
}
