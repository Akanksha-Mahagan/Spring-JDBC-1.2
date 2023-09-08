package com.mahagan.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IOTDeviceMapper implements RowMapper<IOTDevice> {

    public IOTDevice mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        IOTDevice iotDevice = new IOTDevice();
        iotDevice.setId((resultSet.getInt("Id")));
        iotDevice.setDeviceName(resultSet.getString("deviceName"));
        iotDevice.setDeviceNameLocation(resultSet.getString("deviceNameLocation"));
        iotDevice.setDeviceFunction(resultSet.getString("deviceFunction"));
        return iotDevice;
    }
}