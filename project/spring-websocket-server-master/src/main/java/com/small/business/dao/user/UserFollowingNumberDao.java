package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.UserFollowingNumber;

public interface UserFollowingNumberDao {

    public List<UserFollowingNumber> getAllUserFollowingNumber();

    public UserFollowingNumber getUserFollowingNumberById(Long id);

    public long addUserFollowingNumber(UserFollowingNumber userFollowingNumber);

    public boolean deleteUserFollowingNumberById(Long id);

    public boolean updateUserFollowingNumber(UserFollowingNumber userFollowingNumber);


}
