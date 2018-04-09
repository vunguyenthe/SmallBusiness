package com.small.business.service.user;

import java.util.List;

import com.small.business.model.user.UserFollowingNumber;

public interface UserFollowingNumberService {

    public List<UserFollowingNumber> getAllUserFollowingNumber();

    public UserFollowingNumber getUserFollowingNumberById(Long id);

    public long addUserFollowingNumber(UserFollowingNumber userFollowingNumber);

    public boolean deleteUserFollowingNumberById(Long id);

    public boolean updateUserFollowingNumber(UserFollowingNumber userFollowingNumber);

}
