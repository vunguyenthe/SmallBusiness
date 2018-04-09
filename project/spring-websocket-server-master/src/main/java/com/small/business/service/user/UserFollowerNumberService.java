package com.small.business.service.user;

import java.util.List;

import com.small.business.model.user.UserFollowerNumber;

public interface UserFollowerNumberService {

    public List<UserFollowerNumber> getAllUserFollowerNumber();

    public UserFollowerNumber getUserFollowerNumberById(Long id);

    public long addUserFollowerNumber(UserFollowerNumber userFollowerNumber);

    public boolean deleteUserFollowerNumberById(Long id);

    public boolean updateUserFollowerNumber(UserFollowerNumber userFollowerNumber);

}
