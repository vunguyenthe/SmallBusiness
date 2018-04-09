package com.small.business.service.user;

import java.util.List;

import com.small.business.model.user.UserFollow;

public interface UserFollowService {

    public List<UserFollow> getAllUserFollow();

    public UserFollow getUserFollowById(Long id);

    public long addUserFollow(UserFollow userFollow);

    public boolean deleteUserFollowById(Long id);

    public boolean updateUserFollow(UserFollow userFollow);

}
