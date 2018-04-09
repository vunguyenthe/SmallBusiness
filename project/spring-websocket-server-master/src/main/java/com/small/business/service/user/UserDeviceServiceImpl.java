package com.small.business.service.user;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.UserDeviceDao;
import com.small.business.model.user.UserDevice;

@Service("UserDeviceService")
public class UserDeviceServiceImpl implements UserDeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeviceServiceImpl.class);

    @Autowired
    UserDeviceDao userDeviceDao;

    public List<UserDevice> getAllUser() {

        List<UserDevice> userFollowList = userDeviceDao.getAllUserDevice();
        return userFollowList;
    }
    public UserDevice getUserDeviceById(Long id) {

        return userDeviceDao.getUserDeviceById(id);
    }
    public long addUserDevice(UserDevice userDevice) {

        return userDeviceDao.addUserDevice(userDevice);
    }

    public boolean deleteUserDeviceById(Long id) {

        boolean ret;
        ret = userDeviceDao.deleteUserDeviceById(id);
        return ret;
    }

    public boolean updateUserDevice(UserDevice userDevice) {

        return userDeviceDao.updateUserDevice(userDevice);

    }
	@Override
	public List<UserDevice> getAllUserDevice() {
		 return userDeviceDao.getAllUserDevice();
	}

}
