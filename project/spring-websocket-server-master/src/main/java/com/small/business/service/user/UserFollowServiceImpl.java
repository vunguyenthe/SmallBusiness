package com.small.business.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.UserFollowDao;
import com.small.business.model.user.UserFollow;

@Service("UserFollowService")
public class UserFollowServiceImpl implements UserFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowServiceImpl.class);

    @Autowired
    UserFollowDao userFllowDao;

    public List<UserFollow> getAllUser() {

        List<UserFollow> userFollowList = userFllowDao.getAllUserFollow();
        return userFollowList;
    }
    public UserFollow getUserFollowById(Long id) {

        return userFllowDao.getUserFollowById(id);
    }
    public long addUserFollow(UserFollow userFollow) {

        return userFllowDao.addUserFollow(userFollow);
    }

    public boolean deleteUserFollowById(Long id) {

        boolean ret;
        ret = userFllowDao.deleteUserFollowById(id);
        return ret;
    }

    public boolean updateUserFollow(UserFollow userFollow) {

        return userFllowDao.updateUserFollow(userFollow);

    }
	@Override
	public List<UserFollow> getAllUserFollow() {
		 return userFllowDao.getAllUserFollow();
	}

}
