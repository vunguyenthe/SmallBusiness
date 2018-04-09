package com.small.business.service.user;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.UserFollowingNumberDao;
import com.small.business.model.user.UserFollowingNumber;

@Service("UserFollowingNumberService")
public class UserFollowingNumberServiceImpl implements UserFollowingNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowingNumberServiceImpl.class);

    @Autowired
    UserFollowingNumberDao userFllowingNumerDao;

    public List<UserFollowingNumber> getAllUser() {

        List<UserFollowingNumber> userFollowList = userFllowingNumerDao.getAllUserFollowingNumber();
        return userFollowList;
    }
    public UserFollowingNumber getUserFollowingNumberById(Long id) {

        return userFllowingNumerDao.getUserFollowingNumberById(id);
    }
    public long addUserFollowingNumber(UserFollowingNumber userFollow) {

        return userFllowingNumerDao.addUserFollowingNumber(userFollow);
    }

    public boolean deleteUserFollowingNumberById(Long id) {

        boolean ret;
        ret = userFllowingNumerDao.deleteUserFollowingNumberById(id);
        return ret;
    }

    public boolean updateUserFollowingNumber(UserFollowingNumber userFollow) {

        return userFllowingNumerDao.updateUserFollowingNumber(userFollow);

    }
	@Override
	public List<UserFollowingNumber> getAllUserFollowingNumber() {
		 return userFllowingNumerDao.getAllUserFollowingNumber();
	}

}
