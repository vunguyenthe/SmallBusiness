package com.small.business.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.small.business.model.user.User;
import com.small.business.model.user.UserPosition;

public interface UserService {

    public List<User> getAllUser();

    public List<UserPosition> getAllUserPosition();
    
    public Long validateUser(String user, String password);

    public User getUserById(Long id);

    public UserPosition getUserPosition(Long userId);
    
    public long addUser(User User);

    public boolean deleteUserById(Long id);

    public boolean deleteAll();

    public boolean updateUser(User user);

    public String uploadFilePostMethod(MultipartFile file,
            HttpServletRequest request);

}
