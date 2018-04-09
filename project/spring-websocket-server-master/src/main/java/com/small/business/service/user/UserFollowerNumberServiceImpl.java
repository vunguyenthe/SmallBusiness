package com.small.business.service.user;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.UserFollowerNumberDao;
import com.small.business.model.user.UserFollowerNumber;

@Service("UserFollowerNumberService")
public class UserFollowerNumberServiceImpl implements UserFollowerNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowerNumberServiceImpl.class);

    @Autowired
    UserFollowerNumberDao userFllowerNumerDao;

    public List<UserFollowerNumber> getAllUser() {

        List<UserFollowerNumber> userFollowList = userFllowerNumerDao.getAllUserFollowerNumber();
        return userFollowList;
    }
    public UserFollowerNumber getUserFollowerNumberById(Long id) {

        return userFllowerNumerDao.getUserFollowerNumberById(id);
    }
    public long addUserFollowerNumber(UserFollowerNumber userFollow) {

        return userFllowerNumerDao.addUserFollowerNumber(userFollow);
    }

    public boolean deleteUserFollowerNumberById(Long id) {

        boolean ret;
        ret = userFllowerNumerDao.deleteUserFollowerNumberById(id);
        return ret;
    }

    public boolean updateUserFollowerNumber(UserFollowerNumber userFollow) {

        return userFllowerNumerDao.updateUserFollowerNumber(userFollow);

    }
	@Override
	public List<UserFollowerNumber> getAllUserFollowerNumber() {
		 return userFllowerNumerDao.getAllUserFollowerNumber();
	}

}
