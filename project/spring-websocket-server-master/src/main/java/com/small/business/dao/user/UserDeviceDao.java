package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.UserDevice;

public interface UserDeviceDao {

    public List<UserDevice> getAllUserDevice();

    public UserDevice getUserDeviceById(Long id);

    public long addUserDevice(UserDevice userDevice);

    public boolean deleteUserDeviceById(Long id);

    public boolean updateUserDevice(UserDevice userDevice);


}
