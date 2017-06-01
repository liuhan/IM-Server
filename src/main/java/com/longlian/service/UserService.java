package com.longlian.service;

import com.longlian.model.User;

import java.util.Map;
import java.util.UUID;

/**
 * Created by liuhan on 2017-05-31.
 */
public interface UserService {

    public String createUser(User user);

    public String refreshToken(String uuid);

    public void updateUser(User user);

    public Map getUserInfo(String uuid);

    public boolean login(String uuid , String token);

    public User saveInfo(String token , String sessionId);

    public User getUserInfoBySessionId(String sessionId);
}
