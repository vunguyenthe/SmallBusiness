package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.UserFollow;

public interface UserFollowDao {

    public List<UserFollow> getAllUserFollow();

    public UserFollow getUserFollowById(Long id);

    public long addUserFollow(UserFollow userFollow);

    public boolean deleteUserFollowById(Long id);

    public boolean updateUserFollow(UserFollow userFollow);


}
