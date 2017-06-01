package com.longlian.service.impl;

import com.longlian.dao.UserMapper;
import com.longlian.model.User;
import com.longlian.service.UserService;
import com.longlian.util.JsonUtil;
import com.longlian.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.UUID;

/**
 * Created by liuhan on 2017-05-31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate template;
    @Override
    public String createUser(User user) {
        return null;
    }

    @Override
    public String refreshToken(String uuid) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Map getUserInfo(String uuid) {
        return null;
    }

    @Override
    public boolean login(String uuid , String token) {
        User user = userMapper.selectByToken(token);
        if (user != null && user.getUuid().equals(uuid)) {

            return true;
        }
        return false;
    }

    @Override
    public User saveInfo(String token, String sessionId) {
        User user = userMapper.selectByToken(token);
        if (user != null) {
            String str = JsonUtil.toJson(user);
            template.opsForValue().set(RedisKey.USER_LOGIN_INFO_PREFIX + sessionId , str);
        }
        return user;
    }
    @Override
    public User getUserInfoBySessionId( String sessionId) {
        String str = template.opsForValue().get(RedisKey.USER_LOGIN_INFO_PREFIX + sessionId );
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return JsonUtil.getObject(str , User.class);
    }
}
